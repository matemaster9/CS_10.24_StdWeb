import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
public class GetNoArgsTest {

    @Test
    public void visitWebsite() throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet();
        URI uri = URI.create("https://www.apple.com.cn/");
        httpGet.setURI(uri);
        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
        Header[] allHeaders = closeableHttpResponse.getAllHeaders();
        HttpEntity entity = closeableHttpResponse.getEntity();
        StatusLine statusLine = closeableHttpResponse.getStatusLine();
        String content = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        System.out.println(statusLine.getStatusCode());
        System.out.println(content.length());
        for (Header allHeader : allHeaders) {
            System.out.println(allHeader);
        }

        Header[] allHeaders1 = httpGet.getAllHeaders();
        for (Header header : allHeaders1) {
            System.out.println(header);
        }

        URI uri1 = httpGet.getURI();
        System.out.println(uri1);
    }
}
