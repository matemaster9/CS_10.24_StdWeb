package cs.matemaster.demo.config.externalize;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author matemaster
 */
@Data
@Configuration
public class AnotherRandomValueConfig {

    @Value("${random-value.secret}")
    private String secret;

    @Value("${random-value.number}")
    private Integer number;

    @Value("${random-value.big-number}")
    private Long bigNumber;

    @Value("${random-value.uuid}")
    private String uuid;

    @Value("${random-value.less-ten}")
    private Integer lessTen;

    @Value("${random-value.range}")
    private Integer range;
}
