package ih.ifbs.services;

import ih.ifbs.domain.Flight;
import ih.ifbs.exceptions.FlightNotFoundException;
import ih.ifbs.repository.hsqlrepository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FlightServiceImpl implements FlightService {

    //    private final EntityRepository<Flight> flightRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override // CONSOLE APPLICATION SPECIFIC
    public Collection<Flight> getAllFlights(String city, String date) {
        if (!city.equals("") && !date.equals("")) {
            return Stream.concat(filterFlightsByCity(city).stream(),
                    filterFlightsByDate(date).stream()).collect(Collectors.toSet());
        } else if (!city.equals("")) {
            return filterFlightsByCity(city);
        } else if (!date.equals("")) {
            return filterFlightsByDate(date);
        }
        return getAllFlights();
    }

    // CONSOLE APPLICATION SPECIFIC
    private List<Flight> filterFlightsByCity(String city) {
        Pattern cityPattern = Pattern.compile(city);
        List<Flight> filtered1 = flightRepository.findAll().stream()
                .filter(f -> {
                    Matcher match = cityPattern.matcher(f.getArrival());
                    return match.find();
                })
                .collect(Collectors.toList());
        List<Flight> filtered2 = flightRepository.findAll().stream()
                .filter(f -> {
                    Matcher match = cityPattern.matcher(f.getDeparture());
                    return match.find();
                })
                .collect(Collectors.toList());
        return Stream.concat(filtered1.stream(), filtered2.stream()).collect(Collectors.toList());
    }

    // CONSOLE APPLICATION SPECIFIC
    private List<Flight> filterFlightsByDate(String date) {
        Pattern datePattern = Pattern.compile(date);
        return flightRepository.findAll().stream()
                .filter(f -> {
                    Matcher match = datePattern.matcher(f.getFlightSchedule().toString());
                    return match.find();
                })
                .collect(Collectors.toList());
    }

    @Override
    public Flight findById(int id) {
        return flightRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Flight findByFlightNumber(String flightNumber) {
        flightNumber = flightNumber.toUpperCase(Locale.ROOT);
        Flight flight = flightRepository.findByFlightNumber(flightNumber);
        if (flight == null) {
            throw new FlightNotFoundException(flightNumber, "Flight '" + flightNumber + "' not found!");
        }
        return flight;
    }
}
