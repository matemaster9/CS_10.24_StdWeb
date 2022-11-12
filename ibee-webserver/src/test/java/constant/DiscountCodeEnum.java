package constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author matemaster
 */
@Getter
@AllArgsConstructor
public enum DiscountCodeEnum implements ISingleCode {

    None(0),

    Gold(1),

    Platinum(2),

    Diamond(3);

    private final int code;

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static DiscountCodeEnum getRandomCode() {
        return DiscountCodeEnum.values()[random.nextInt(0, DiscountCodeEnum.values().length)];
    }
}
