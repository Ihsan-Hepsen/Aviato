package ih.ifbs.repository;

import ih.ifbs.domain.Flight;
import ih.ifbs.domain.FlightType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class HSQLFlightRepository {

    private static final Logger log = LoggerFactory.getLogger(HSQLFlightRepository.class);
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert flightInserter;

    public HSQLFlightRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.flightInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("FLIGHTS").usingGeneratedKeyColumns("ID");
    }

    private Flight mapRow(ResultSet rs, int mapRow) throws SQLException {
        return new Flight(rs.getString("airline"),
                rs.getString("flight_number"), FlightType.valueOf(rs.getString("flight_type")),
                rs.getString("departure"), rs.getString("arrival"),
                LocalDate.parse(rs.getString("date")), rs.getBoolean("on_time"));
    }

    // TODO: Change the method name!
    public List<Flight> findByName(String name) {
        return jdbcTemplate.query("SELECT * FROM FLIGHTS WHERE FLIGHT_NUMBER = ?", this::mapRow, name);
    }
}
