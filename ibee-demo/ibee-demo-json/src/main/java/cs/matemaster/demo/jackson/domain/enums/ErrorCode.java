package cs.matemaster.demo.jackson.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author matemaster
 */
public enum ErrorCode {

    SUCCESS("SUC0000", "成功"),
    UNKNOWN("ERR0000", "未知错误");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @JsonCreator
    public static ErrorCode forValues(@JsonProperty("code") String code, @JsonProperty("message") String message) {
        ErrorCode[] values = ErrorCode.values();
        for (ErrorCode value : values) {
            if (value.getCode().equals(code) && value.getMessage().equals(message)) {
                return value;
            }
        }
        return null;
    }
}