package ih.ifbs.repository.hsqlrepository;

import ih.ifbs.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    @Query("SELECT p FROM Passenger p WHERE p.transitPassenger = ?1")
    List<Passenger> findAllByTransitPassenger(boolean transit);
}
