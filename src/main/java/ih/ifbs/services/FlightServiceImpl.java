package ih.ifbs.services;

import ih.ifbs.domain.Flight;
import ih.ifbs.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FlightServiceImpl implements FlightService {
    // TODO: services & methods that the presentation layer needs

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.generateFlight(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.getFlights();
    }

    @Override
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

    private List<Flight> filterFlightsByCity(String city) {
        Pattern cityPattern = Pattern.compile(city);
        List<Flight> filtered1 = flightRepository.getFlights().stream()
                .filter(f -> {
                    Matcher match = cityPattern.matcher(f.getArrival());
                    return match.find();
                })
                .collect(Collectors.toList());
        List<Flight> filtered2 = flightRepository.getFlights().stream()
                .filter(f -> {
                    Matcher match = cityPattern.matcher(f.getDeparture());
                    return match.find();
                })
                .collect(Collectors.toList());
        return Stream.concat(filtered1.stream(), filtered2.stream()).collect(Collectors.toList());
    }

    private List<Flight> filterFlightsByDate(String date) {
        Pattern datePattern = Pattern.compile(date);
        return flightRepository.getFlights().stream()
                .filter(f -> {
                    Matcher match = datePattern.matcher(f.getFlightSchedule().toString());
                    return match.find();
                })
                .collect(Collectors.toList());
    }
}