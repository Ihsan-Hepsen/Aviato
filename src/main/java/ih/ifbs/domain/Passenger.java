package ih.ifbs.domain;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import javax.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger extends EntityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    private final String name;

    @Column(name = "age", nullable = false)
    private final int age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private final Gender gender;

    @SerializedName("transit")
    @Column(name = "passenger_type", nullable = false)
    private final boolean transitPassenger;

//    @Column(name = "flights", nullable = false)
    @ManyToMany(mappedBy = "flights", cascade = {CascadeType. DETACH,
            CascadeType.MERGE, CascadeType. PERSIST, CascadeType. REFRESH}, fetch = FetchType.EAGER)
    private transient final List<Flight> flights;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Passenger(String name, int age, Gender gender, boolean isTransitPassenger) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.transitPassenger = isTransitPassenger;
        this.flights = new ArrayList<>();
    }

    protected Passenger() {
        this.name = null;
        this.age = 18;
        this.gender = Gender.M; // default
        this.transitPassenger = false;
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isTransitPassenger() {
        return transitPassenger;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public int getNumberOfFlights() {
        return flights == null ? 0 : flights.size();
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d\nGender: %s\nTransit: %s\nFlights: %d\n",
                name, age, gender.getGender(), transitPassenger ? "Yes" : "No", flights.size());
    }
}
