package cs.matemaster.demo.config.yaml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties("mac-studio")
public class MacStudio {

    private Overview overview;
    private String display;
    private String storeSpace;
    private String[] supports;
    private Map<String, List<String>> resources;

    @Data
    public static class Overview {
        private String osInfo;
        private String model;
        private String silicon;
        private Integer memory;
        private String sequenceNumber;
    }
}
