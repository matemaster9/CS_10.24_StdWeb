package cs.matemaster.demo.jedis;

import cs.matemaster.demo.jedis.constant.SystemConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author matemaster
 */
@SpringBootApplication(scanBasePackages = {
        SystemConstants.AppPackage,
        SystemConstants.JacksonPackage
})
public class JedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(JedisApplication.class, args);
    }
}
