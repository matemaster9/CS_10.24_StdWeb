package cs.matemaster.tech.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author matemaster
 */
@SpringBootApplication(scanBasePackages = {
        "cs.matemaster.tech.redis",
        "cs.matemaster.tech.springdoc",
        "cs.matemaster.jackson"
})
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
