package ih.ifbs.presentation;

import ih.ifbs.domain.Gender;
import ih.ifbs.domain.Passenger;
import ih.ifbs.presentation.dto.PassengerDTO;
import ih.ifbs.services.PassengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/passengers")
public class PassengerController {

    private final Logger logger = LoggerFactory.getLogger(PassengerController.class);
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public String displayPassengers(Model model) {
        logger.info("Displaying passenger list");
        model.addAttribute("passengers", passengerService.getAllPassengers());
        return "passengers";
    }

    @GetMapping("/add")
    public String showPassengerForm(Model model) {
        logger.info("Showing add passenger form");
        model.addAttribute("genders", Gender.values());
        return "add-passengers";
    }

    @GetMapping("/details")
    public String showPassengerDetails(@RequestParam(value = "pId") int id, Model model) {
        Passenger passenger = passengerService.findById(id);
        logger.debug("Showing details of " + passenger);
        model.addAttribute("passenger", passenger);
        return "passenger-details";
    }

    @PostMapping("/add")
    public String collectFields(PassengerDTO pDTO) {
        logger.info("collecting data from passenger form fields...");
        Passenger passenger = new Passenger(pDTO.getName(), pDTO.getAge(),
                pDTO.getGender(), pDTO.getIsTransitPassenger().equalsIgnoreCase("true"));
        passengerService.createPassenger(passenger);
        logger.info("new passenger '" + passenger.getName() + "' added");
        return "redirect:/passengers";
    }

}
