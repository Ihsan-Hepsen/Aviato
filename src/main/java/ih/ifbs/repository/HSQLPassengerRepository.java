package ih.ifbs.repository;

import ih.ifbs.domain.Gender;
import ih.ifbs.domain.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HSQLPassengerRepository implements HSQLRepository<Passenger> {

    private static final Logger log = LoggerFactory.getLogger(HSQLFlightRepository.class);
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert passengerInserter;

    public HSQLPassengerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.passengerInserter = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("PASSENGERS")
                .usingGeneratedKeyColumns("ID");
    }

    @Override
    public Passenger mapRow(ResultSet rs, int mapRow) throws SQLException {
        log.debug("Returning passengers with ResultSet");
        return new Passenger(rs.getString("name"), rs.getInt("age"),
                Gender.lookup(rs.getString("gender")),
                rs.getBoolean("transit"));
    }

    @Override
    public List<Passenger> read() {
        return jdbcTemplate.query("SELECT * FROM PASSENGERS", this::mapRow);
    }

    @Override
    public Passenger save(Passenger passenger) {
        log.debug("Saving passenger: " + passenger);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("NAME", passenger.getName());
        parameters.put("AGE", passenger.getAge());
        parameters.put("GENDER", passenger.getGender().toString());
        parameters.put("TRANSIT", passenger.isTransitPassenger());
        parameters.put("FLIGHTS", passenger.getNumberOfFlights());
        passenger.setId(passengerInserter.executeAndReturnKey(parameters).intValue());
        return passenger;
    }

    @Override
    public List<Passenger> delete(Passenger passenger) {
        log.debug("Deleting passenger: " + passenger);
        return jdbcTemplate.query("DELETE FROM PASSENGERS WHERE ID = ?", this::mapRow, passenger.getId());
    }

    @Override
    public List<Passenger> findById(int id) {
        log.debug("Trying to find passenger with id: " + id);
        return jdbcTemplate.query("SELECT * FROM PASSENGERS WHERE id = ?", this::mapRow, id);
    }

    public List<Passenger> findByName(String name) {
        log.debug("Trying to find passenger '" + name + "'...");
        return jdbcTemplate.query("SELECT * FROM PASSENGERS WHERE FLIGHT_NUMBER = ?", this::mapRow, name);
    }
}
