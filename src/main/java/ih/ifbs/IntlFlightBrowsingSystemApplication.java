package ih.ifbs;

import ih.ifbs.presentation.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IntlFlightBrowsingSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntlFlightBrowsingSystemApplication.class, args);

        // FOR CONSOLE APPLICATION ONLY!!
//        ConfigurableApplicationContext context =
//                SpringApplication.run(IntlFlightBrowsingSystemApplication.class, args);
//        View view = context.getBean(View.class);
//        view.displayMainMenu();
//        context.close();
        // FOR CONSOLE APPLICATION ONLY!!
    }
}
