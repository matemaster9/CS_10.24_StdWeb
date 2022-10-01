package cs.matemaster.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
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

    public static String serializeIgnoreNull(Object arg) {
        try {
            OBJECT_MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
            return OBJECT_MAPPER.writeValueAsString(arg);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    public static <T> T deserialize(String jsonStr, Class<T> targetType) {
        try {
            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return OBJECT_MAPPER.readValue(jsonStr, targetType);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    public static <T> T deserialize(String jsonStr, TypeReference<T> typeReference) {
        try {
            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return OBJECT_MAPPER.readValue(jsonStr, typeReference);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }
}
