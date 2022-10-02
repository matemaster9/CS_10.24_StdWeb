package cs.matemaster.demo.config.yaml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties("login.user")
public class LoginUser {

    private String uuid;

    private List<String> roles;
}
