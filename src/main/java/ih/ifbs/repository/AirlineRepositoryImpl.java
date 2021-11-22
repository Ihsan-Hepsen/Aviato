package ih.ifbs.repository;

import ih.ifbs.domain.Airline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirlineRepositoryImpl extends ListRepository<Airline> implements AirlineRepository {

    private static final Logger logger = LoggerFactory.getLogger(AirlineRepositoryImpl.class);

    @Autowired
    public AirlineRepositoryImpl() {
        logger.debug("Creating airline repository");
    }
}
