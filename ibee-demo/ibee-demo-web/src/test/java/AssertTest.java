import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author matemaster
 */
public class AssertTest {

    @Test
    public void test() {
        Integer number = 256;
        Assert.isTrue(number == 256, "==判断");
    }
}
