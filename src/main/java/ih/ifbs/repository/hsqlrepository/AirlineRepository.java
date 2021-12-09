package ih.ifbs.repository.hsqlrepository;

import ih.ifbs.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {
    Airline findAirlineByAirlineName(String airline);
}
