import org.apache.hc.core5.net.URIBuilder;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
public class UriTest {

    @Test
    public void case1(){
        try {
            URI build = new URIBuilder()
                    .setCharset(StandardCharsets.UTF_8)
                    .setScheme("http")
                    .setHost("localhost")
                    .setPort(8080)
                    .build();
            System.out.println(build);
        } catch (URISyntaxException e) {
            System.out.println("语法错误");
            throw new RuntimeException(e);
        }
    }
}
