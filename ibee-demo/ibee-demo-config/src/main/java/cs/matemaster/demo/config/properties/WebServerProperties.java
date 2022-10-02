package cs.matemaster.demo.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "web.server")
public class WebServerProperties {

    private Map<String, String> application;
    private Map<String, List<String>> config;
    private Map<String, Credential> users;

    @Data
    public static class Credential {
        private String username;
        private String password;
    }
}