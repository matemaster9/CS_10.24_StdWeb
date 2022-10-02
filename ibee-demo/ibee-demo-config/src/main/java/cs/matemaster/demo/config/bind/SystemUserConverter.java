package cs.matemaster.demo.config.bind;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.matemaster.demo.config.bind.model.SystemUser;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
@ConfigurationPropertiesBinding
public class SystemUserConverter implements Converter<String, SystemUser> {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public SystemUser convert(String ymlValue) {
        try {
            return OBJECT_MAPPER.readValue(ymlValue, SystemUser.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
