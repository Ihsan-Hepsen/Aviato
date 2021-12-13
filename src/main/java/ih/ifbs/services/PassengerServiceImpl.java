package ih.ifbs.services;

import ih.ifbs.domain.Passenger;
import ih.ifbs.repository.EntityRepository;
import ih.ifbs.repository.hsqlrepository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {
    
//    private final EntityRepository<Passenger> repository;
    private final PassengerRepository repository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Passenger findById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return repository.save(passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return repository.findAll();
    }

    @Override
    public List<Passenger> getAllPassengers(boolean isTransit) {
        return repository.findAll().stream()
                .filter(n -> isTransit == n.isTransitPassenger())
                .collect(Collectors.toList());
    }

    @Override
    public List<Passenger> findAllByTransitPassenger(boolean isTransit) {
        return repository.findAllByTransitPassenger(isTransit);
    }

}
