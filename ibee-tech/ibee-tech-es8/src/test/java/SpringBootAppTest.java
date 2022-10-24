import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import cs.matemaster.tech.es8.ElasticApplication;
import cs.matemaster.tech.es8.model.StaffWorkLogDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author matemaster
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticApplication.class)
public class SpringBootAppTest {

    private static final Logger elasticLogger = LoggerFactory.getLogger(SpringBootAppTest.class);

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Test
    public void case1() {
        StaffWorkLogDto workLog = new StaffWorkLogDto();
        workLog.setStaffCode("MateMaster");
        workLog.setWorkingHours(7);
        workLog.setOnDuty(LocalDate.now().atTime(8, 30));
        workLog.setOffDuty(LocalDate.now().atTime(17, 30));

        IndexRequest<StaffWorkLogDto> request = IndexRequest.of(indexRequestBuilder ->
                indexRequestBuilder.index("staffworklog")
                        .id(workLog.getStaffCode())
                        .document(workLog)
        );

        IndexResponse response = null;
        try {
            response = elasticsearchClient.index(request);
        } catch (IOException e) {
            elasticLogger.error(e.getMessage());
        }

        elasticLogger.info(request.toString());
        elasticLogger.info(response.toString());
    }
}
