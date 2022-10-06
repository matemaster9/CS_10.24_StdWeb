import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.Test;

import java.io.IOException;

/**
 * @author matemaster
 */
public class EntityTest {

    @Test
    public void stringEntity() throws IOException, ParseException {
        StringEntity stringEntity = new StringEntity("http message", ContentType.APPLICATION_JSON, false);
        System.out.println(stringEntity.getContentType());
        System.out.println(stringEntity.getContentLength());
        System.out.println(stringEntity.getContentEncoding());
        System.out.println(EntityUtils.toString(stringEntity));
    }
}
