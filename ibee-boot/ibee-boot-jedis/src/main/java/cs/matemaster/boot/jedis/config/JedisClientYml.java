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
public class JedisClientYml {

    private String host;

    private Integer port;

    private String password;

    private Long maxWaitMills;

    private Integer maxTotal;

    private Integer maxIdle;

    private Integer minIdle;

    private Boolean testOnBorrow;

    private Boolean testOnReturn;

    private Boolean testWhileIdle;

    private Long timeBetweenEvictionRunsMillis;

    private Boolean blockWhenExhausted;

    private Boolean info;

    private Boolean jmxEnabled;

    private Boolean fairness;

    private Long minEvictableIdleTimeMillis;

    private Integer numTestsPerEvictionRun;
}
