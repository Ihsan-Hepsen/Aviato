package ih.ifbs.repository;

import ih.ifbs.domain.Flight;
import ih.ifbs.domain.Passenger;
import java.util.List;

public interface PassengerRepository {
    Passenger createPassenger(Passenger passenger);

    Passenger createPassenger(Passenger passenger, Flight flight);

    List<Passenger> getPassengers();
}
