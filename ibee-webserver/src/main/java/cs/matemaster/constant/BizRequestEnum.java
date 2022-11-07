package cs.matemaster.constant;

import lombok.Getter;

/**
 * @author matemaster
 */
public enum BizRequestEnum implements IBizCodeEnum {

    LowLevel(1),

    MiddleLevel(2),

    HighLevel(3);

    private final int code;

    BizRequestEnum(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }
}
