package com.example.intl_flight_browsing_system;

import com.example.intl_flight_browsing_system.presentation.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IntlFlightBrowsingSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(IntlFlightBrowsingSystemApplication.class, args);
        View view = context.getBean(View.class);
        view.displayMainMenu();
        context.close();
    }
}
