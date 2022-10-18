import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author matemaster
 */
public class BizTest {

    private static final Logger bizLogger = LoggerFactory.getLogger(BizTest.class);

    @Test
    public void joinStr() {
        String prefix = "SystemUser";
        String key = "st";
        bizLogger.debug(String.join(":", prefix, key));
    }
}
