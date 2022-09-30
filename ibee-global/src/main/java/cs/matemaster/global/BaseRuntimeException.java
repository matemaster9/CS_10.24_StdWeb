package cs.matemaster.global;

import lombok.Data;

/**
 * @author matemaster
 */
@Data
public class BaseRuntimeException extends RuntimeException{

    private BaseCode errorCode;

    private Object extraMessage;


    public BaseRuntimeException() {
        super(ErrorCode.UNKNOWN.getMessage());
        errorCode = ErrorCode.UNKNOWN;
    }

    public BaseRuntimeException(BaseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.extraMessage = null;
    }

    public BaseRuntimeException(BaseCode errorCode, Object extraMessage) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.extraMessage = extraMessage;
    }
}
