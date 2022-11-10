package cs.matemaster.config.redis;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@Schema(name = "RedisYaml", description = "redis配置")
@ConfigurationProperties(prefix = "redis")
public class RedisYaml {
    @Schema(description = "主机")
    private String host;

    @Schema(description = "端口")
    private Integer port;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "最大空闲等待时间")
    private Long maxWaitMills;

    @Schema(description = "最大连接数")
    private Integer maxTotal;

    @Schema(description = "最大空闲")
    private Integer maxIdle;

    @Schema(description = "最小空闲")
    private Integer minIdle;

    @Schema(description = "获取对象时测试")
    private Boolean testOnBorrow;

    @Schema(description = "归还对象测试")
    private Boolean testOnReturn;

    @Schema(description = "空闲测试")
    private Boolean testWhileIdle;

    private Long timeBetweenEvictionRunsMillis;

    private Boolean blockWhenExhausted;

    private Boolean info;

    private Boolean jmxEnabled;

    private Boolean fairness;

    private Long minEvictableIdleTimeMillis;

    private Integer numTestsPerEvictionRun;
}
