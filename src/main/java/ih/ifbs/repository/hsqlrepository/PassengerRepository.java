package ih.ifbs.repository.hsqlrepository;

import ih.ifbs.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
