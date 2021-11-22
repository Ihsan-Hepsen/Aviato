package ih.ifbs.services;

import ih.ifbs.domain.Airline;
import ih.ifbs.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AirlineServiceImpl implements AirlineService {

    private final ListRepository<Airline> repository;

    @Autowired
    public AirlineServiceImpl(ListRepository<Airline> airlineRepository) {
        this.repository = airlineRepository;
    }

    @Override
    public Airline findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Airline addAirline(Airline airline) {
        return repository.create(airline);
    }

    @Override
    public List<Airline> getAllAirlines() {
        return repository.read();
    }
}
