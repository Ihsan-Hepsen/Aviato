package ih.ifbs.services;

import ih.ifbs.domain.Passenger;
import java.util.List;

public interface PassengerService {
    Passenger findById(int id);
    Passenger createPassenger(Passenger passenger);
    List<Passenger> getAllPassengers();
    List<Passenger> getAllPassengers(boolean isTransit);
    List<Passenger> findAllByTransitPassenger(boolean isTransit); // JPA
}
