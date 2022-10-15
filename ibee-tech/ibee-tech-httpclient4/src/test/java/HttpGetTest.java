import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

import java.net.URI;
import java.util.Arrays;

/**
 * @author matemaster
 */
public class HttpGetTest {

    @Test
    public void get() {
        HttpGet httpGet = new HttpGet();
        URI uri = URI.create("https://www.apple.com.cn/");
        httpGet.setURI(uri);

        System.out.println(httpGet.getMethod());
        System.out.println(httpGet.getConfig());
        System.out.println(Arrays.toString(httpGet.getAllHeaders()));
        System.out.println(httpGet.getProtocolVersion());
        System.out.println(httpGet.getRequestLine());
        System.out.println(httpGet.getURI());
    }
}
