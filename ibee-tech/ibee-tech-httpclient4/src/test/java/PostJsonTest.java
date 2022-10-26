import cs.matemaster.httpclient4.SystemUserDto;
import cs.matemaster.jackson.JacksonUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author matemaster
 */
public class PostJsonTest {

    @Test
    public void postJson() throws IOException {
        SystemUserDto systemUserDto = new SystemUserDto();
        systemUserDto.setUsername("mate-master");
        systemUserDto.setPassword("jhfgvbuhahsj");

        String serialize = JacksonUtil.serialize(systemUserDto);

        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080");

        StringEntity stringEntity = new StringEntity(serialize, StandardCharsets.UTF_8);
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = aDefault.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode());
        aDefault.close();
    }
}
