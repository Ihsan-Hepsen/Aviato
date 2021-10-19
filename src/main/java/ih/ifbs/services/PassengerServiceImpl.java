package ih.ifbs.services;

import ih.ifbs.domain.Passenger;
import ih.ifbs.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassengerServiceImpl implements PassengerService {
    
    private final ListRepository<Passenger> repository;

    @Autowired
    public PassengerServiceImpl(ListRepository<Passenger> repository) {
        this.repository = repository;
    }

    @Override
    public Passenger findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return repository.create(passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return repository.read();
    }

    @Override
    public List<Passenger> getAllPassengers(boolean isTransit) {
        return repository.read().stream()
                .filter(n -> isTransit == n.isTransitPassenger())
                .collect(Collectors.toList());
    }
}
