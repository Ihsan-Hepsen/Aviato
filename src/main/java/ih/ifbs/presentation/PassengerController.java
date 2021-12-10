package ih.ifbs.presentation;

import ih.ifbs.domain.Passenger;
import ih.ifbs.presentation.dto.PassengerDTO;
import ih.ifbs.services.PassengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

    // Genders disappear after one invalid attempt, therefore I use Converter to fix the issue.
    @GetMapping("/add")
    public String showPassengerForm(Model model) {
        logger.info("Showing add passenger form");
        model.addAttribute("passenger", new PassengerDTO());
        return "add-passengers";
    }

    @GetMapping("/details")
    public String showPassengerDetails(@RequestParam(value = "pId") int id, Model model) {
        Passenger passenger = passengerService.findById(id);
        logger.debug("Showing details of " + passenger);
        model.addAttribute("passenger", passenger);
        return "passenger-details";
    }

    @RequestMapping(value = "/filtered{t}", method = RequestMethod.GET)
    public String showFilteredPassengers(@PathVariable("t") @RequestParam(value = "t") String condition, Model model) {
        boolean isTransit = Boolean.parseBoolean(condition);
        logger.debug("Showing all " + isTransit + " passengers");
        model.addAttribute("passengers", passengerService.findAllByTransitPassenger(isTransit));
        return "passengers";
    }

    @PostMapping("/add")
    public String handlePassenger(@Valid @ModelAttribute("passenger") PassengerDTO pDTO, BindingResult errors, Model model) {
        logger.info("collecting data from passenger form fields...");
        model.addAttribute("errors", errors);
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> logger.error(error.toString()));
            return "add-passengers";
        } else {
            String fullName = pDTO.getName() + " " + pDTO.getLastName();
            Passenger passenger = new Passenger(fullName, pDTO.getAge(),
                    pDTO.getGender(), pDTO.isTransitPassenger());
            passengerService.createPassenger(passenger);
            logger.info("new passenger '" + passenger.getName() + "' added");
            return "redirect:/passengers";
        }
    }
}
