package cs.matemaster.httpclient;

import org.apache.hc.client5.http.HttpRequestRetryStrategy;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.util.TimeValue;

/**
 * @author matemaster
 */
public final class HttpClientUtil {

    private static final CloseableHttpClient ApacheHttpClient;

    static {
        PoolingHttpClientConnectionManager manager = PoolingHttpClientConnectionManagerBuilder.create()
                .setMaxConnTotal(200)
                .setMaxConnPerRoute(50)
                .setConnectionTimeToLive(TimeValue.ofMinutes(3L))
                .build();

        RequestConfig requestConfig = RequestConfig.custom().build();

        HttpRequestRetryStrategy retryStrategy = null;

        ApacheHttpClient = HttpClients.custom()
                .build();

    }
}
