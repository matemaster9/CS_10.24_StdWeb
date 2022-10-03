import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author matemaster
 */
public class BusinessTest {

    @Test
    public void test() {
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")));
    }
}
