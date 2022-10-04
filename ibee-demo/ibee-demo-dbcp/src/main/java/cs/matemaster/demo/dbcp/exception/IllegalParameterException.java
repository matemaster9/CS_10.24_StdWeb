package cs.matemaster.demo.dbcp.exception;

import cs.matemaster.global.BaseCode;
import cs.matemaster.global.BaseRuntimeException;

/**
 * @author matemaster
 */
public class IllegalParameterException extends BaseRuntimeException {

    public IllegalParameterException(BaseCode errorCode) {
        super(errorCode);
    }
}
