package ih.ifbs.repository;

import ih.ifbs.domain.Airline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class AirlineRepositoryImpl extends ListRepository<Airline> {

//    private static final List<Airline> airlines = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(AirlineRepositoryImpl.class);

    @Autowired
    public AirlineRepositoryImpl() {
        logger.debug("Creating airline repository");
    }

//    static {
//        initAirlines();
//    }
//
//    private static void initAirlines() {
//        airlines.add(new Airline("Qantas Airlines", 134, 77));
//        airlines.add(new Airline("Turkish Airlines", 350, 304));
//        airlines.add(new Airline("Air New Zealand", 114, 80));
//        airlines.add(new Airline("Virgin Australia", 68, 40));
//        airlines.add(new Airline("Bahamas Air", 10, 21));
//        airlines.add(new Airline("Private Voyages", 11, 13));
//    }
//
//
//    @Override
//    public List<Airline> getAirlines() {
//        return airlines;
//    }
}
