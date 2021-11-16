package ih.ifbs.repository;

import ih.ifbs.domain.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PassengerRepositoryImpl extends ListRepository<Passenger> {

    private static final Logger logger = LoggerFactory.getLogger(PassengerRepositoryImpl.class);

    @Autowired
    public PassengerRepositoryImpl() {
        logger.debug("Creating passengers repository");
    }
}
