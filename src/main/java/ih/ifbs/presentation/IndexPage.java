package ih.ifbs.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class IndexPage {
    private final Logger logger = LoggerFactory.getLogger(IndexPage.class);

    @GetMapping
    public String displayIndexPage() {
        logger.info("Index page is on display.");
        return "index";
    }
}
