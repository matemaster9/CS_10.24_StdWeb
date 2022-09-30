package cs.matemaster.global;

import lombok.Data;

/**
 * @author matemaster
 */
@Data
public class SuccessTip extends AbstractTip {

    private Object data;

    public SuccessTip(Object data) {
        this.data = data;
        setCode(ErrorCode.SUCCESS.getCode());
        setMessage(ErrorCode.SUCCESS.getMessage());
        setTimestamp(System.currentTimeMillis());
    }
}
