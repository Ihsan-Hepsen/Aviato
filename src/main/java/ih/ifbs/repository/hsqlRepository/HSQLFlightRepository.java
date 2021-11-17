package ih.ifbs.repository.hsqlRepository;

import ih.ifbs.domain.Flight;
import ih.ifbs.domain.FlightType;
import ih.ifbs.repository.EntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HSQLFlightRepository implements EntityRepository<Flight> {

    private static final Logger log = LoggerFactory.getLogger(HSQLFlightRepository.class);
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert flightInserter;

    public HSQLFlightRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.flightInserter = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("FLIGHTS")
                .usingGeneratedKeyColumns("ID");
    }

    public Flight mapRow(ResultSet rs, int mapRow) throws SQLException {
        log.debug("Displaying flights with ResultSet");
        Flight flight = new Flight(rs.getString("airline"),
                rs.getString("flight_number"), FlightType.lookup(rs.getString("flight_type")),
                rs.getString("departure"), rs.getString("arrival"),
                LocalDate.parse(rs.getString("date")), rs.getBoolean("on_time"));
        flight.setId(rs.getInt("id"));
        return flight;
    }

    @Override
    public List<Flight> read() {
        log.debug("Returning all flights.");
        return jdbcTemplate.query("SELECT * FROM FLIGHTS", this::mapRow);
    }

    @Override
    public Flight create(Flight flight){
        log.debug("Saving flight: " + flight);
        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("ID", flight.getId());
        parameters.put("AIRLINE", flight.getAirline());
        parameters.put("FLIGHT_NUMBER", flight.getFlightNumber());
        parameters.put("FLIGHT_TYPE", flight.getFlightType().toString());
        parameters.put("DEPARTURE", flight.getDeparture());
        parameters.put("ARRIVAL", flight.getArrival());
        parameters.put("DATE", flight.getFlightSchedule());
        parameters.put("ON_TIME", flight.isOnTime());
        flight.setId(flightInserter.executeAndReturnKey(parameters).intValue());
        return flight;
    }

    @Override
    public void delete(Flight flight) {
        log.debug("Deleting flight: " + flight);
        jdbcTemplate.queryForObject("DELETE FROM FLIGHTS WHERE ID = ?", this::mapRow, flight.getId());
    }

    @Override
    public void update(Flight flight) {

    }

    public Flight findById(int id) {
        log.debug("Flight found with id: " + id);
        return jdbcTemplate.queryForObject("SELECT * FROM FLIGHTS WHERE id = ?", this::mapRow, id);
    }

    // TODO: Change this method!
    public List<Flight> findByFlightNumber(String flightNumber) {
        log.debug("Trying to find flight '" + flightNumber + "'...");
        return jdbcTemplate.query("SELECT * FROM FLIGHTS WHERE FLIGHT_NUMBER = ?", this::mapRow, flightNumber);
    }
}
