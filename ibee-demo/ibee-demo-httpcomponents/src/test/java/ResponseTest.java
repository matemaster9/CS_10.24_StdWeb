import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.http.message.BasicHttpResponse;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author matemaster
 */
public class ResponseTest {

    @Test
    public void case1() {
        HttpResponse basicHttpResponse = new BasicHttpResponse(HttpStatus.SC_OK, "OK");
        System.out.println(basicHttpResponse.getCode());
        System.out.println(basicHttpResponse.getVersion());
        System.out.println(basicHttpResponse.getReasonPhrase());

        List<BasicHeader> headerList = new ArrayList<>();
        headerList.add(new BasicHeader("Set-Cookie", "c1=a; path=/; domain=localhost"));
        headerList.add(new BasicHeader("Set-Cookie", "c2=b; path=\"/\", c3=c; domain=\"localhost\""));
        headerList.forEach(basicHttpResponse::addHeader);

        Header firstHeader = basicHttpResponse.getFirstHeader("Set-Cookie");
        Header lastHeader = basicHttpResponse.getLastHeader("Set-Cookie");
        Header[] headerArray = basicHttpResponse.getHeaders("Set-Cookie");

        System.out.println(firstHeader);
        System.out.println(lastHeader);
        System.out.println(Arrays.toString(headerArray));

        Iterator<Header> headerIterator = basicHttpResponse.headerIterator("Set-Cookie");
        while (headerIterator.hasNext()) {
            System.out.println(headerIterator.next());
        }
    }

    @Test
    public void closableResponse() {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = client.execute(new HttpGet("http://localhost:8080/home"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
