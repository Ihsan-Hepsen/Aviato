package ih.ifbs.repository;

import ih.ifbs.domain.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FlightRepositoryImpl extends ListRepository<Flight> {

    private static final Logger logger = LoggerFactory.getLogger(FlightRepositoryImpl.class);

    public FlightRepositoryImpl() {
        logger.debug("Creating flights repository");
    }
}
