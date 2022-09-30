package cs.matemaster.global;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author matemaster
 */
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseRuntimeException.class)
    public ErrorTip getBaseRuntimeException(BaseRuntimeException err) {
        BaseCode errorCode = err.getErrorCode();
        return new ErrorTip(err.getExtraMessage(), errorCode.getCode(), errorCode.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ErrorTip getException(Exception err) {
        System.out.println(err.getMessage());
        return new ErrorTip();
    }
}
