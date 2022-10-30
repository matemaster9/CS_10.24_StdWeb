import co.elastic.clients.elasticsearch.core.MgetRequest;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author matemaster
 */
public class MgetTest {

    @Test
    public void test1() {
        MgetRequest mgetRequest = MgetRequest.of(builder -> builder
                .index("work-log")
                .ids("2022-10-26", "2022-10-27")
        );

        System.out.println(mgetRequest);
    }

    @Test
    public void test2() {
        MgetRequest mgetRequest = MgetRequest.of(builder -> builder
                .index("work-log")
                .ids(Arrays.asList("2022-10-26", "2022-10-27"))
        );

        System.out.println(mgetRequest);
    }
}
