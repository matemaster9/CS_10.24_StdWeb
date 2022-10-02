package cs.matemaster.demo.config.externalize;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author matemaster
 */
@Component
@ConfigurationProperties(prefix = "standard")
public class StandardConfig {

    public StandardConfig() {
    }

    private String username;

    private String password;

    private List<String> inetAddressList;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getInetAddressList() {
        return inetAddressList;
    }

    public void setInetAddressList(List<String> inetAddressList) {
        this.inetAddressList = inetAddressList;
    }

    @Override
    public String toString() {
        return "StandardConfig{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", inetAddressList=" + inetAddressList +
                '}';
    }
}
