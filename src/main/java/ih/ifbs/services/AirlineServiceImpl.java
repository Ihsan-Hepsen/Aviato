package ih.ifbs.services;

import ih.ifbs.domain.Airline;
import ih.ifbs.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirlineServiceImpl implements AirlineService {
    // TODO: services & methods that the presentation layer needs

    private final AirlineRepository repository;

    @Autowired
    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.repository = airlineRepository;
    }

    @Override
    public List<Airline> getAirlines() {
        return repository.getAirlines();
    }
}
