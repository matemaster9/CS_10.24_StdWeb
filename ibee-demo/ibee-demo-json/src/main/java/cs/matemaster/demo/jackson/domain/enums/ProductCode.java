package cs.matemaster.demo.jackson.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author matemaster
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProductCode {

    PC("AK89798", "个人电脑");

    private final String code;
    private final String message;

    ProductCode(String code, String message) {
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
