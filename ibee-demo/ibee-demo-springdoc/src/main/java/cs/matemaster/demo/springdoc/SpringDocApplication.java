package cs.matemaster.demo.springdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author matemaster
 */
@SpringBootApplication(scanBasePackages = {
        "cs.matemaster.demo.springdoc",
        "cs.matemaster.tech.springdoc"
})
public class SpringDocApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDocApplication.class, args);
    }
}
