import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.elasticsearch.indices.GetIndexRequest;
import org.junit.Test;

/**
 * @author matemaster
 */
public class IndexTest {

    @Test
    public void create() {
        CreateIndexRequest indexRequest = CreateIndexRequest.of(builder -> builder.index("bank_account"));
        System.out.println(indexRequest);
    }

    @Test
    public void get() {
        GetIndexRequest indexRequest = GetIndexRequest.of(builder -> builder.index("bank_account"));
        System.out.println(indexRequest);
    }

    @Test
    public void delete() {
        DeleteIndexRequest indexRequest = DeleteIndexRequest.of(builder -> builder.index("bank_account"));
        System.out.println(indexRequest);
    }
}
