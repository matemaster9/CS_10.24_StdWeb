package cs.matemaster.boot.jedis.config;

import lombok.Data;

/**
 * @author matemaster
 */
@Data
public abstract class AbstractJedisClientYml {

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
