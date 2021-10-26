package ih.ifbs.configuration;

import ih.ifbs.util.StringToFlightTypeConverter;
import ih.ifbs.util.StringToGenderConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToGenderConverter());
        registry.addConverter(new StringToFlightTypeConverter());
    }
}
