package cs.matemaster.demo.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import cs.matemaster.demo.jackson.domain.enums.MyEnum;

import java.io.IOException;

/**
 * @author matemaster
 */
public class MyEnumSerializer extends StdSerializer<MyEnum> {

    public MyEnumSerializer() {
        super(MyEnum.class);
    }

    public MyEnumSerializer(Class<MyEnum> t) {
        super(t);
    }

    @Override
    public void serialize(MyEnum myEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("code");
        jsonGenerator.writeString(myEnum.getCode());
        jsonGenerator.writeFieldName("message");
        jsonGenerator.writeString(myEnum.getMessage());
        jsonGenerator.writeEndObject();
    }
}
