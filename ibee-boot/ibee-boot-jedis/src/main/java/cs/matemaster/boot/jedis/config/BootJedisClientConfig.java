package cs.matemaster.boot.jedis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "boot.redis")
public class BootJedisClientConfig  extends AbstractJedisClientYml {
}
