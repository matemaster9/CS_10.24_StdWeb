package cs.matemaster.demo.dbcp.constant;

import cs.matemaster.global.BaseCode;

/**
 * @author matemaster
 */
public enum DbcpErrorCode implements BaseCode {
    DELETE_SYS_USER_ERROR("ERRA001", "删除系统用户错误"),
    ADD_SYS_USER_ERROR("ERRA002", "新增系统用户错误"),
    UPDATE_SYS_USER_ERROR("ERRA003", "更新系统用户错误"),

    ;

    private final String code;
    private final String message;

    DbcpErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
