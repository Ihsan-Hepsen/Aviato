package ih.ifbs.services;

import ih.ifbs.domain.Airline;
import ih.ifbs.repository.EntityRepository;
import ih.ifbs.repository.collectionbased.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService {

    private final EntityRepository<Airline> repository;

    @Autowired
    public AirlineServiceImpl(EntityRepository<Airline> airlineRepository) {
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
