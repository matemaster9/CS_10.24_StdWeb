package cs.matemaster.demo.jedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author matemaster
 */
@SpringBootApplication(scanBasePackages = {
        "cs.matemaster.demo.jedis",
        "cs.matemaster.jackson"
})
public class JedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(JedisApplication.class, args);
    }
}
