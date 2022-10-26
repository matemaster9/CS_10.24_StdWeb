package cs.matemaster.tech.es8.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticYml {

    /**
     * es 用户
     */
    private String username;

    /**
     * es 密码
     */
    private String password;

    /**
     * es 端口
     */
    private Integer port;

    /**
     * es 服务器地址
     */
    private String address;

    /**
     * es 连接协议
     */
    private String scheme;
}
