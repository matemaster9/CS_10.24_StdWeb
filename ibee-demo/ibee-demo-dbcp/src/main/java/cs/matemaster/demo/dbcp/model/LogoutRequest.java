package cs.matemaster.demo.dbcp.model;

import cs.matemaster.demo.dbcp.exception.IllegalParameterException;
import cs.matemaster.global.ErrorCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author matemaster
 */
@Data
public class LogoutRequest {

    private String username;

    private String phoneNumber;

    private String password;

    public void check() {
        if (StringUtils.isBlank(username)) {
            throw new IllegalParameterException(ErrorCode.ILLEGAL_PARAMETER);
        }
        if (StringUtils.isBlank(phoneNumber)) {
            throw new IllegalParameterException(ErrorCode.ILLEGAL_PARAMETER);
        }
        if (StringUtils.isBlank(password)) {
            throw new IllegalParameterException(ErrorCode.ILLEGAL_PARAMETER);
        }
    }
}
