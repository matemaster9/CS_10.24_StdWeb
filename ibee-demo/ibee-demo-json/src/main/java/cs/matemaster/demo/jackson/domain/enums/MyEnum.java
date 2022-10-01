package cs.matemaster.demo.jackson.domain.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import cs.matemaster.demo.jackson.MyEnumDeserializer;
import cs.matemaster.demo.jackson.MyEnumSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author matemaster
 */
@JsonSerialize(using = MyEnumSerializer.class)
@JsonDeserialize(using = MyEnumDeserializer.class)
public enum MyEnum {

    EXAMPLE("EX907098", "例子"),
    CASE("EX8789", "案例");

    private final String code;
    private final String message;

    MyEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
