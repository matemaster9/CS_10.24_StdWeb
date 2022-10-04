package cs.matemaster.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author matemaster
 */
@Getter
@AllArgsConstructor
public enum ErrorCode implements BaseCode {

    SUCCESS("SUC0000", "成功"),
    UNKNOWN("ERR0000", "未知错误"),

    ILLEGAL_PARAMETER("ERROOO1", "非法参数"),
    ;

    private final String code;
    private final String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
