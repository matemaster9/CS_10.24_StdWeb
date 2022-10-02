package cs.matemaster.demo.config.externalize;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "random-value")
public class RandomValueConfig {

    private String secret;

    private Integer number;

    private Long bigNumber;

    private String uuid;

    private Integer lessTen;

    private Integer range;
}
