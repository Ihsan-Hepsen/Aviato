package ih.ifbs.repository;

import ih.ifbs.domain.Flight;
import ih.ifbs.domain.Passenger;
import java.util.List;

public interface PassengerRepository {
    Passenger create(Passenger passenger);
//    Passenger create(Passenger passenger, Flight flight);
    Passenger findById(int id);
    List<Passenger> read();
}
