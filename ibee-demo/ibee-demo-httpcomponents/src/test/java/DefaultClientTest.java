import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.junit.Test;

/**
 * @author matemaster
 */
public class DefaultClientTest {

    @Test
    public void case1() {
        CloseableHttpClient defaultClient = HttpClients.createDefault();
    }
}
