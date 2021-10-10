package ih.ifbs.presentation;

import ih.ifbs.domain.Airline;
import ih.ifbs.domain.Flight;
import ih.ifbs.domain.FlightType;
import ih.ifbs.services.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flights")
public class FlightController {

    private final Logger logger = LoggerFactory.getLogger(FlightController.class);
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public String displayFlights(Model model) {
        logger.info("displaying flights...");
        model.addAttribute("flights", flightService.getAllFlights());
        return "flights";
    }

    @GetMapping("/add")
    public String showFlightForm(Model model) {
        logger.info("Showing add passenger form");
        model.addAttribute("types", FlightType.values());
        return "add-flight";
    }

    @PostMapping("/add")
    public String collectFields(Flight f) {
        logger.info("collecting flight fields...");
        Airline airline = new Airline(f.getAirline(), 30, 60);
        Flight flight = new Flight(f.getAirline(), f.getFlightNumber(), f.getFlightType(), f.getDeparture(), f.getArrival(),
                f.getFlightSchedule(), true);
        flightService.addFlight(flight);
        logger.info("new flight '" + flight.getFlightNumber() + "' added to flight list");
        return "redirect:/flights";
    }
}
