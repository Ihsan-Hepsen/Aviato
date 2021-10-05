package ih.ifbs.services;

import ih.ifbs.domain.Passenger;
import java.util.List;

public interface PassengerService {
    Passenger createPassenger(Passenger passenger);

    List<Passenger> getAllPassengers();

    List<Passenger> getAllPassengers(boolean isTransit);
}
