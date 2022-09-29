package cs.matemaster.web;

import cs.matemaster.web.constant.ScannablePackages;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author matemaster
 */
@SpringBootApplication(scanBasePackages = {
        ScannablePackages.WebApp,
        ScannablePackages.Swagger
})
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
