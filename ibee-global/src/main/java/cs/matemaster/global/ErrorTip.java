package cs.matemaster.global;

import lombok.Data;

/**
 * @author matemaster
 */
@Data
public class ErrorTip extends AbstractTip{

    private Object errorMessage;

    public ErrorTip() {
        this.errorMessage = "";
        setCode(ErrorCode.UNKNOWN.getCode());
        setMessage(ErrorCode.UNKNOWN.getMessage());
        setTimestamp(System.currentTimeMillis());
    }

    public ErrorTip(Object errorMessage, String code, String message) {
        this.errorMessage = errorMessage;
        setCode(code);
        setMessage(message);
        setTimestamp(System.currentTimeMillis());
    }
}
