package ih.ifbs.repository.hsqlrepository;

import ih.ifbs.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    List<Passenger> findByTransitPassenger(boolean transit);
}
