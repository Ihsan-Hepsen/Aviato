package ih.ifbs.services;

import ih.ifbs.domain.Airline;
import ih.ifbs.domain.Flight;

import java.util.List;

public interface AirlineService {
    Airline findById(int id);
    Airline addAirline(Airline airline);
    List<Airline> getAllAirlines();
    Airline findAirlineByAirlineName(String airline);
}
