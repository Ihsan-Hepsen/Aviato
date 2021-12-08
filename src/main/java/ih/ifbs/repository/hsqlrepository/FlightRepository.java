package ih.ifbs.repository.hsqlrepository;

import ih.ifbs.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query("SELECT f FROM Flight f WHERE f.flightNumber = ?1")
    List<Flight> findByFlightNumber(String flightNumber);
}
