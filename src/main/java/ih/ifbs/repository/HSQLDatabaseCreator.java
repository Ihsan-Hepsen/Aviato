package ih.ifbs.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

public class HSQLDatabaseCreator {
    private static final Logger log = LoggerFactory.getLogger(HSQLDatabaseCreator.class);
    private final JdbcTemplate jdbcTemplate;

    public HSQLDatabaseCreator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void loadData() {
        log.debug("Loading data from the HSQL database...");
        jdbcTemplate.update("DROP TABLE IF EXISTS FLIGHTS");
        jdbcTemplate.update(
                "CREATE TABLE FLIGHTS(" +
                        "    ID INTEGER NOT NULL IDENTITY," +
                        "    AIRLINE VARCHAR(50) NOT NULL," +
                        "    FLIGHT_NUMBER VARCHAR(25) NOT NULL," +
                        "    FLIGHT_TYPE VARCHAR(25) NOT NULL," +
                        "    DEPARTURE VARCHAR(50) NOT NULL," +
                        "    ARRIVAL VARCHAR(50) NOT NULL," +
                        "    DATE DATE NOT NULL," +
                        "    ON_TIME BOOLEAN NOT NULL" +
                        ");");
        jdbcTemplate.update("INSERT INTO FLIGHTS(AIRLINE, FLIGHT_NUMBER, FLIGHT_TYPE, DEPARTURE, ARRIVAL, DATE, ON_TIME)" +
                "VALUES ('Golden Wings', 'G1456', 'PRIV', 'Sydney', 'Gold Coast', DATE '2021-11-21', true)," +
                "       ('Qantas Airlines', 'QF12', 'COMM', 'Los Angeles','Sydney', DATE '2021-10-21', true)," +
                "       ('Turkish Airlines','TK77', 'COMM', 'Istanbul','Miami', DATE '2021-10-22', false)," +
                "       ('Private Voyages','HI4506', 'PRIV', 'Honolulu','Sydney', DATE '2021-10-21', true)," +
                "       ('Air New Zealand', 'NZ6141', 'COMM', 'Auckland','Sydney', DATE '2021-10-22', false)," +
                "       ('Bahamas Air', 'BHS224', 'COMM', 'Miami', 'Nassau', DATE '2021-10-23', false)," +
                "       ('Virgin Australia', 'VA526', 'COMM', 'Sydney', 'Gold Coast', DATE '2021-10-22', true)," +
                "       ('Virgin Australia', 'VA734', 'COMM', 'Gold Coast', 'Melbourne', DATE '2021-10-23', false)," +
                "       ('Private Voyages', 'HI1204', 'PRIV', 'New York', 'Miami', DATE '2021-10-23', false)," +
                "       ('Iberia Airlines', 'IB3013', 'COMM', 'Barcelona', 'Madrid', DATE '2021-11-19', true)," +
                "       ('All Nippon Airways', 'NH802', 'COMM', 'Singapore', 'Tokyo', DATE '2021-12-13', true);");
        jdbcTemplate.update("DROP TABLE IF EXISTS PASSENGERS");
        jdbcTemplate.update("CREATE TABLE PASSENGERS(" +
                "    ID INTEGER NOT NULL IDENTITY," +
                "    NAME VARCHAR(100) NOT NULL," +
                "    AGE INTEGER NOT NULL," +
                "    GENDER VARCHAR(20) NOT NULL," +
                "    TRANSIT BOOLEAN NOT NULL," +
                "    FLIGHTS INTEGER" +
                ");");
        jdbcTemplate.update("INSERT INTO PASSENGERS(name, age, gender, transit, flights)" + 
                "VALUES('Johnny Thunder', 21, 'M', TRUE, 3)," +
                "      ('Anna Cooper', 23, 'F', TRUE, 2)," +
                "      ('Padme Amidala', 35, 'F', FALSE, 1)," +
                "      ('Kilroy Barron', 52, 'M', FALSE, 1)," +
                "      ('Senor Palomar', 32, 'M', FALSE, 1)," +
                "      ('Kül Tigin', 37, 'M', FALSE, 1)," +
                "      ('Valaria Ferreria', 26, 'F', FALSE, 1)," +
                "      ('Akane Tanaka', 34, 'F', FALSE, 1);");
    }
}
