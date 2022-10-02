package cs.matemaster.demo.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import cs.matemaster.demo.jackson.domain.enums.MyEnum;

import java.io.IOException;

/**
 * @author matemaster
 */
public class MyEnumDeserializer extends StdDeserializer<MyEnum> {

    public MyEnumDeserializer() {
        super(MyEnum.class);
    }

    protected MyEnumDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public MyEnum deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        String code = treeNode.get("code").asText();
        String message = treeNode.get("message").asText();

        MyEnum[] values = MyEnum.values();
        for (MyEnum value : values) {
            if (value.getCode().equals(code) && value.getMessage().equals(message)) {
                return value;
            }
        }
        return null;
    }
}
