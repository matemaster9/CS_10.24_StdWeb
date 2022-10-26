import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.GetRequest;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import cs.matemaster.tech.es8.model.StaffWorkLogDto;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author matemaster
 */
public class ElasticApiTest {

    @Test
    public void test1() {
        StaffWorkLogDto workLog = new StaffWorkLogDto();
        workLog.setWorkingHours(8);
        workLog.setStaffCode("80327878");
        workLog.setOnDuty(LocalDateTime.now().minusHours(8));
        workLog.setOffDuty(LocalDateTime.now());


        IndexRequest<StaffWorkLogDto> request = IndexRequest.of(builder -> builder
                .index("work-log")
                .id("2022-10-26")
                .document(workLog)
        );

        System.out.println(request);
    }

    @Test
    public void test2() {
        MatchQuery matchQuery = MatchQuery.of(builder -> builder
                .field("workingHours")
                .query(8)
        );
        System.out.println(matchQuery);


        Query query = Query.of(builder -> builder.match(matchQuery));
        System.out.println(query);

        SearchRequest searchRequest = SearchRequest.of(builder -> builder
                .index("work-log")
                .query(query)
        );
        System.out.println(searchRequest);
    }

    @Test
    public void test3() {
        GetRequest request = GetRequest.of(builder -> builder
                .index("work-log")
                .id("2022-10-26")
        );

        // GET /work-log/_doc/2022-10-26
        System.out.println(request);
    }
}
