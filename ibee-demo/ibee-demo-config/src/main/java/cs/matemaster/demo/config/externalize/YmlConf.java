package cs.matemaster.demo.config.externalize;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Data
@EnableConfigurationProperties(YmlConf.class)
@ConfigurationProperties(prefix = "yaml")
public class YmlConf {

    private List<String> stringList;

    private Map<String, Object> stringObjectMap;

    private String[] stringArray;
}
