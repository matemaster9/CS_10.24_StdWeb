package cs.matemaster.boot.jedis.config;

import lombok.Data;

/**
 * @author matemaster
 */
@Data
public abstract class AbstractJedisClientYml {

    /**
     * redis服务器ip
     */
    private String host;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 密码
     */
    private String password;

    /**
     * 最大等待时间
     */
    private Long maxWaitMills;

    /**
     * 最大连接数
     */
    private Integer maxTotal;

    /**
     * 最大空闲连接
     */
    private Integer maxIdle;

    /**
     * 最小空闲连接
     */
    private Integer minIdle;

    /**
     * 获取对象时测试连接
     */
    private Boolean testOnBorrow;

    /**
     * 归还对象时测试连接
     */
    private Boolean testOnReturn;

    /**
     * 空闲时测试连接
     */
    private Boolean testWhileIdle;

    /**
     *
     */
    private Long timeBetweenEvictionRunsMillis;

    /**
     * 无资源时、阻塞或报错
     */
    private Boolean blockWhenExhausted;

    /**
     * 遵循FIFO
     */
    private Boolean info;

    /**
     * jmx测试
     */
    private Boolean jmxEnabled;

    /**
     * 公平锁
     */
    private Boolean fairness;

    /**
     *
     */
    private Long minEvictableIdleTimeMillis;

    /**
     *
     */
    private Integer numTestsPerEvictionRun;
}
