package ih.ifbs.bootstrap;

import ih.ifbs.domain.*;
import ih.ifbs.repository.hsqlrepository.AirlineRepository;
import ih.ifbs.repository.hsqlrepository.FlightRepository;
import ih.ifbs.repository.hsqlrepository.PassengerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.stream.Stream;

@Configuration
//@Profile("dev-hiber")
@Transactional
public class DataSeedingHibernate implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataSeedingHibernate.class);
    private final AirlineRepository airlines;
    private final PassengerRepository passengers;
    private final FlightRepository flights;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public DataSeedingHibernate(AirlineRepository airlines, PassengerRepository passengers, FlightRepository flights) {
        this.airlines = airlines;
        this.passengers = passengers;
        this.flights = flights;
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("Seeding the repositories(hibernate)");

        Airline a1 = new Airline("Qantas Airlines", 134, 77);
        Airline a2 = new Airline("Turkish Airlines", 350, 304);
        Airline a3 = new Airline("Air New Zealand", 114, 80);
        Airline a4 = new Airline("Virgin Australia", 68, 40);
        Airline a5 = new Airline("Bahamas Air", 10, 21);
        Airline a6 = new Airline("Private Voyages", 11, 13);
        Airline a7 = new Airline("Iberia Airlines", 68, 120);
        Airline a8 = new Airline("All Nippon Airways", 220, 75);

        Passenger p1 = new Passenger("Johnny Thunder", 21, Gender.M, true);
        Passenger p2 = new Passenger("Anna Cooper", 23, Gender.F, true);
        Passenger p3 = new Passenger("Padme Amidala", 35, Gender.F, false);
        Passenger p4 = new Passenger("Kilroy Barron", 52, Gender.M, false);
        Passenger p5 = new Passenger("Senor Palomar", 32, Gender.M, false);
        Passenger p6 = new Passenger("Kül Tigin", 37, Gender.M, false);
        Passenger p7 = new Passenger("Valeria Ferreira", 26, Gender.F, false);
        Passenger p8 = new Passenger("Akane Tanaka", 34, Gender.F, false);

        Flight f1 = new Flight("Qantas Airlines", "QF12", FlightType.COMM,
                "Los Angeles", "Sydney",
                LocalDate.of(2021, 10, 21), true);
        Flight f2 = new Flight("Turkish Airlines", "TK77", FlightType.COMM,
                "Istanbul", "Miami",
                LocalDate.of(2021, 10, 22), false);
        Flight f3 = new Flight("Private Voyages", "HI4506", FlightType.PRIV,
                "Honolulu", "Sydney",
                LocalDate.of(2021, 10, 21), true);
        Flight f4 = new Flight("Air New Zealand", "NZ6141", FlightType.COMM,
                "Auckland", "Sydney",
                LocalDate.of(2021, 10, 22), false);
        Flight f5 = new Flight("Bahamas Air", "BHS224", FlightType.COMM,
                "Miami", "Nassau",
                LocalDate.of(2021, 10, 23), false);
        Flight f6 = new Flight("Virgin Australia", "VA526", FlightType.COMM,
                "Sydney", "Gold Coast",
                LocalDate.of(2021, 10, 22), true);
        Flight f7 = new Flight("Virgin Australia", "VA734", FlightType.COMM,
                "Gold Coast", "Melbourne",
                LocalDate.of(2021, 10, 23), false);
        Flight f8 = new Flight("Private Voyages", "HI1204", FlightType.PRIV,
                "New York", "Miami",
                LocalDate.of(2021, 10, 23), false);
        Flight f9 = new Flight("Iberia Airlines", "IB3013", FlightType.COMM,
                "Barcelona", "Madrid",
                LocalDate.of(2021, 11, 19), true);
        Flight f10 = new Flight("All Nippon Airways", "NH802", FlightType.COMM,
                "Singapore", "Tokyo",
                LocalDate.of(2021, 12, 13), true);

        EntityManager em = entityManagerFactory.createEntityManager();

        airlines.save(a1);
        airlines.save(a2);
        airlines.save(a3);
        airlines.save(a4);
        airlines.save(a5);
        airlines.save(a6);
        airlines.save(a7);
        airlines.save(a8);

        flights.save(f1);
        flights.save(f2);
        flights.save(f3);
        flights.save(f4);
        flights.save(f5);
        flights.save(f6);
        flights.save(f7);
        flights.save(f8);
        flights.save(f9);
        flights.save(f10);

        passengers.save(p1);
        passengers.save(p2);
        passengers.save(p3);
        passengers.save(p4);
        passengers.save(p5);
        passengers.save(p6);
        passengers.save(p7);
        passengers.save(p8);

        a1.addFlight(f1);
        a2.addFlight(f2);
        a6.addFlight(f3);
        a3.addFlight(f4);
        a5.addFlight(f5);
        a4.addFlight(f6);
        a4.addFlight(f7);
        a6.addFlight(f8);
        a7.addFlight(f9);
        a8.addFlight(f10);

        p1.addFlight(f1);
        p1.addFlight(f6);
        p1.addFlight(f7);
        p2.addFlight(f2);
        p3.addFlight(f3);
        p4.addFlight(f4);
        p5.addFlight(f5);
        p6.addFlight(f8);
        p7.addFlight(f9);
        p8.addFlight(f10);

        f1.addPassenger(p1);
        f2.addPassenger(p2);
        f3.addPassenger(p3);
        f4.addPassenger(p4);
        f5.addPassenger(p5);
        f8.addPassenger(p6);
        f9.addPassenger(p7);
        f10.addPassenger(p8);

//        em.getTransaction().begin();
//        em.persist(f1);
//        em.persist(f2);
//        em.persist(f3);
//        em.persist(f4);
//        em.persist(f5);
//        em.persist(f6);
//        em.persist(f7);
//        em.persist(f8);
//        em.persist(f9);
//        em.persist(f10);
//
//        em.persist(p1);
//        em.persist(annaCooper);
//        em.persist(padmeAmidala);
//        em.persist(kilroyBarron);
//        em.persist(senorPaloma);
//        em.persist(kulTigin);
//        em.persist(valeriaFerreria);
//        em.persist(akaneTeneka);
//        em.getTransaction().commit();
//        em.close();
    }
}
