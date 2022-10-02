package cs.matemaster.httpclient;

import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.util.TimeValue;

/**
 * @author matemaster
 */
public final class HttpClientUtil {

    private static final PoolingHttpClientConnectionManager Manager;


    static {
        Manager = PoolingHttpClientConnectionManagerBuilder.create()
                .setMaxConnTotal(200)
                .setMaxConnPerRoute(50)
                .setConnectionTimeToLive(TimeValue.ofMinutes(3L))
                .build();
    }
}
