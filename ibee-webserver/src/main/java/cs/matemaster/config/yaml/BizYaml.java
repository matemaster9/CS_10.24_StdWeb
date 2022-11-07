package cs.matemaster.config.yaml;

import cs.matemaster.constant.BizRequestEnum;
import cs.matemaster.model.dto.BizRequestHandlerDto;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author matemaster
 */
@Data
@Component
@ConfigurationProperties(prefix = "biz-request")
public class BizYaml {

    private Map<BizRequestEnum, BizRequestHandlerDto> bizMap;
}
