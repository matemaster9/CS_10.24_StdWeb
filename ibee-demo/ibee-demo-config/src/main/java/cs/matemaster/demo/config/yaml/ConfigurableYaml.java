package cs.matemaster.demo.config.yaml;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "configurable-yaml")
public class ConfigurableYaml {

    private String username;

    private Integer age;

    private int[] ports;

    private List<String> servers;

    private Map<String, Object> logMap;

    private Map<String, List<Integer>> httpCode;

    private String computerYear;

    private boolean enable;

    private COM com;

    @Getter
    public enum COM {
        Oracle,
        Apple
    }
}
