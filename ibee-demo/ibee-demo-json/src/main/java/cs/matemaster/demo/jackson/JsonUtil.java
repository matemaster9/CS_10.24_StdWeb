package cs.matemaster.demo.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author matemaster
 */
public final class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String serialize(Object arg) {
        if (arg == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(arg);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    public static String serializeIgnoreNull(Object arg) {
        if (arg == null) {
            return null;
        }
        try {
            OBJECT_MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
            return OBJECT_MAPPER.writeValueAsString(arg);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    public static <T> T deserialize(String jsonStr, Class<T> type) {
        if (jsonStr == null) {
            return null;
        }

        try {
            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return OBJECT_MAPPER.readValue(jsonStr, type);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }

    public static <T> T deserialize(String jsonStr, TypeReference<T> typeReference) {
        if (jsonStr == null) {
            return null;
        }

        try {
            OBJECT_MAPPER.disable(JsonGenerator.Feature.IGNORE_UNKNOWN);
            return OBJECT_MAPPER.readValue(jsonStr, typeReference);
        } catch (JsonProcessingException ignore) {
            return null;
        }
    }
}
