package ih.ifbs.bootstrap;

import ih.ifbs.domain.*;
import ih.ifbs.repository.EntityRepository;
import ih.ifbs.repository.collectionbased.AirlineRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.time.LocalDate;
import java.util.stream.Stream;

@Configuration
@Profile("dev-hiber")
public class DataSeedingHibernate implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataSeedingHibernate.class);
    private final EntityRepository<Airline> airlines;
    private final EntityRepository<Passenger> passengers;
    private final EntityRepository<Flight> flights;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public DataSeedingHibernate(EntityRepository<Airline> airlineRepository, EntityRepository<Passenger> passengerRepository,
                                EntityRepository<Flight> flightRepository) {
        this.airlines = airlineRepository;
        this.passengers = passengerRepository;
        this.flights = flightRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("Seeding the repositories(hibernate)");

        Airline qantas = new Airline("Qantas Airlines", 134, 77);
        Airline turkish = new Airline("Turkish Airlines", 350, 304);
        Airline newZealand = new Airline("Air New Zealand", 114, 80);
        Airline virginAustralia = new Airline("Virgin Australia", 68, 40);
        Airline bahamasAir = new Airline("Bahamas Air", 10, 21);
        Airline privateVoyages = new Airline("Private Voyages", 11, 13);
        Airline iberia = new Airline("Iberia Airlines", 68, 120);
        Airline ana = new Airline("All Nippon Airways", 220, 75);

        Passenger johhnyThunder = new Passenger("Johnny Thunder", 21, Gender.M, true);
        Passenger annaCooper = new Passenger("Anna Cooper", 23, Gender.F, true);
        Passenger padmeAmidala = new Passenger("Padme Amidala", 35, Gender.F, false);
        Passenger kilroyBarron = new Passenger("Kilroy Barron", 52, Gender.M, false);
        Passenger senorPaloma = new Passenger("Senor Palomar", 32, Gender.M, false);
        Passenger kulTigin = new Passenger("Kül Tigin", 37, Gender.M, false);
        Passenger valeriaFerreria = new Passenger("Valeria Ferreira", 26, Gender.F, false);
        Passenger akaneTeneka = new Passenger("Akane Tanaka", 34, Gender.F, false);

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

        qantas.addFlight(f1);
        turkish.addFlight(f2);
        privateVoyages.addFlight(f3);
        newZealand.addFlight(f4);
        bahamasAir.addFlight(f5);
        virginAustralia.addFlight(f6);
        virginAustralia.addFlight(f7);
        privateVoyages.addFlight(f8);
        iberia.addFlight(f9);
        ana.addFlight(f10);

        f1.addPassenger(johhnyThunder);
        f2.addPassenger(annaCooper);
        f3.addPassenger(padmeAmidala);
        f4.addPassenger(kilroyBarron);
        f5.addPassenger(senorPaloma);
        f6.addPassenger(johhnyThunder);
        f7.addPassenger(johhnyThunder);
        f8.addPassenger(kulTigin);
        f9.addPassenger(valeriaFerreria);
        f10.addPassenger(akaneTeneka);

        em.getTransaction().begin();
        em.persist(f1);
        em.persist(f2);
        em.persist(f3);
        em.persist(f4);
        em.persist(f5);
        em.persist(f6);
        em.persist(f7);
        em.persist(f8);
        em.persist(f9);
        em.persist(f10);
        
        em.persist(johhnyThunder);
        em.persist(annaCooper);
        em.persist(padmeAmidala);
        em.persist(kilroyBarron);
        em.persist(senorPaloma);
        em.persist(kulTigin);
        em.persist(valeriaFerreria);
        em.persist(akaneTeneka);
        em.getTransaction().commit();
        em.close();
    }
}
