package cs.matemaster.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author matemaster
 */
public final class JacksonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JacksonUtil() {
    }

    public static String serialize(Object arg) {
        try {
            return OBJECT_MAPPER.writeValueAsString(arg);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }
}
