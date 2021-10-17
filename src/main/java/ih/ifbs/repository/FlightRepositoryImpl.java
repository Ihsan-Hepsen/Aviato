package ih.ifbs.repository;

import ih.ifbs.domain.Airline;
import ih.ifbs.domain.Flight;
import ih.ifbs.domain.FlightType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightRepositoryImpl extends ListRepository<Flight> {

    private static final List<Flight> flights = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(FlightRepositoryImpl.class);

    public FlightRepositoryImpl() {
        logger.debug("Creating flights repository");
    }

    
//    static {
//        fillFlights();
//    }
//
//    private static void fillFlights() {
//        flights.add(new Flight("Qantas Airlines", "QF12", FlightType.COMM,
//                "Los Angeles","Sydney",
//                LocalDate.of(2021, 9, 21), true));
//        flights.add(new Flight("Turkish Airlines","TK77", FlightType.COMM,
//                "Istanbul","Miami",
//                LocalDate.of(2021, 9, 22), false));
//        flights.add(new Flight("Private Voyages","HI4506", FlightType.PRIV,
//                "Honolulu","Sydney",
//                LocalDate.of(2021, 9, 21), true));
//        flights.add(new Flight("Air New Zealand", "NZ6141", FlightType.COMM,
//                "Auckland","Sydney",
//                LocalDate.of(2021, 9, 22), false));
//        flights.add(new Flight("Bahamas Air", "BHS224", FlightType.COMM,
//                "Miami", "Nassau",
//                LocalDate.of(2021, 9, 23), false));
//        flights.add(new Flight("Virgin Australia", "VA526", FlightType.COMM,
//                "Sydney", "Gold Coast",
//                LocalDate.of(2021, 9, 22), true));
//        flights.add(new Flight("Virgin Australia", "VA734", FlightType.COMM,
//                "Gold Coast", "Melbourne",
//                LocalDate.of(2021, 9, 23), false));
//        flights.add(new Flight("Private Voyages", "HI1204", FlightType.PRIV,
//                "New York", "Miami",
//                LocalDate.of(2021, 9, 23), false));
//    }
//
//    @Override
//    public Flight generateFlight(Flight flight) {
//        logger.info("creating new flight by adding to its airline");
//        Airline airline = new Airline(flight.getAirline(), 30, 30);
//        airline.addFlight(flight);
//        flights.add(flight);
//        return flight;
//    }
//
//    @Override
//    public List<Flight> getFlights() {
//        return flights;
//    }
}
