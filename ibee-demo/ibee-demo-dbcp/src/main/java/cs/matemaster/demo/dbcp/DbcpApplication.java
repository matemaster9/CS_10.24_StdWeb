package cs.matemaster.demo.dbcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author matemaster
 */
@SpringBootApplication(scanBasePackages = {
        "cs.matemaster.demo.dbcp",
        "cs.matemaster.swagger"
})
public class DbcpApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbcpApplication.class, args);
    }
}
