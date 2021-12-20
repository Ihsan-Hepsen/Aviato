package ih.ifbs.presentation;

import ih.ifbs.domain.Flight;
import ih.ifbs.domain.Passenger;
import ih.ifbs.services.FlightService;
import ih.ifbs.services.PassengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/flight-booking")
public class FlightBookingController {

    private final Logger log = LoggerFactory.getLogger(FlightBookingController.class);
    private final FlightService flightService;
    private final PassengerService passengerService;

    @Autowired
    public FlightBookingController(FlightService flightService, PassengerService passengerService) {
        this.flightService = flightService;
        this.passengerService = passengerService;
    }

    @GetMapping
    public String displayBookingForm(Model model) {
        log.debug("Showing flight booking page");
        model.addAttribute("passengers", passengerService.getAllPassengers());
        model.addAttribute("flights", flightService.getAllFlights());
        return "flight-booking";
    }

//    @RequestMapping(value = "/booked", method = RequestMethod.POST)

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public @ResponseBody String bookFlight(@ModelAttribute Passenger passenger,
                             @ModelAttribute Flight flight) {
        flight.addPassenger(passenger);
        log.info("Passenger " + passenger.getId() + " booked the flight with the ID-" + flight.getId());
//        return "redirect:../home";
        return "OK";
    }

}
