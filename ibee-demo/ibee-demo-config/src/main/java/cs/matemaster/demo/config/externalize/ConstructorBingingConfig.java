package cs.matemaster.demo.config.externalize;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

/**
 * @author matemaster
 */

@ConstructorBinding
@ConfigurationProperties(prefix = "constructor")
@EnableConfigurationProperties(ConstructorBingingConfig.class)
public class ConstructorBingingConfig {

    private final String username;

    private final String password;

    private final List<String> inetAddressList;

    public ConstructorBingingConfig(String username, String password, @DefaultValue List<String> inetAddressList) {
        this.username = username;
        this.password = password;
        this.inetAddressList = inetAddressList;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getInetAddressList() {
        return inetAddressList;
    }

    @Override
    public String toString() {
        return "ConstructorBingingConfig{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", inetAddressList=" + inetAddressList +
                '}';
    }
}
