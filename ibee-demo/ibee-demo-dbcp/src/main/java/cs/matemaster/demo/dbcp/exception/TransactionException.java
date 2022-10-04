package cs.matemaster.demo.dbcp.exception;

import cs.matemaster.global.BaseCode;
import cs.matemaster.global.BaseRuntimeException;

/**
 * @author matemaster
 */
public class TransactionException extends BaseRuntimeException {

    public TransactionException(BaseCode errorCode) {
        super(errorCode);
    }
}
