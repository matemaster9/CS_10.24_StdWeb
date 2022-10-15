import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author matemaster
 */
public class HttpRequestTest {

    @Test
    public void httpGet() {
        URI uri = URI.create("http://localhost:8080");
        HttpGet httpGet = new HttpGet(uri);
        System.out.println(httpGet);
    }


    @Test
    public void httpPost() {
        HttpPost httpPost = new HttpPost();
    }

    @Test
    public void whenPostRequestUsingHttpClient_thenCorrect()
            throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://hc.apache.org/");
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", "John"));
        params.add(new BasicNameValuePair("password", "pass"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        CloseableHttpResponse response = client.execute(httpPost);
        client.close();
    }
}
