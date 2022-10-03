import cn.hutool.core.lang.Console;
import cs.matemaster.common.GMUtil;
import org.junit.Test;

/**
 * @author matemaster
 */
public class CryptoTest {

    @Test
    public void test() {
        Console.log(GMUtil.sm3("mate-master"));
    }
}
