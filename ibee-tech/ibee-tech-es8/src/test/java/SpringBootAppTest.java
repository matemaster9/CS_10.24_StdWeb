import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import cs.matemaster.tech.es8.ElasticApplication;
import cs.matemaster.tech.es8.model.StaffWorkLogDto;
import cs.matemaster.tech.es8.model.SystemUserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            elasticLogger.info(request.toString());
            elasticLogger.info(response.toString());
        } catch (IOException e) {
            elasticLogger.error(e.getMessage());
        }
    }

    @Test
    public void test2() {
        List<SystemUserDto> systemUserList = Stream.generate(SystemUserDto::mock).limit(10).collect(Collectors.toList());

        BulkRequest.Builder bulkRequestBuilder = new BulkRequest.Builder();
        systemUserList.forEach(systemUser -> bulkRequestBuilder.operations(opr -> opr.index(
                idx -> idx.index("systemuser")
                        .id(String.valueOf(systemUser.getUsername()))
                        .document(systemUser)
        )));

        BulkRequest bulkRequest = bulkRequestBuilder.build();

        try {
            BulkResponse response = elasticsearchClient.bulk(bulkRequest);
            elasticLogger.info(bulkRequest.toString());
            elasticLogger.info(response.toString());
        } catch (IOException e) {
            elasticLogger.debug(e.getMessage());
        }
    }

    @Test
    public void test3() {
        try {
            GetResponse<SystemUserDto> response = elasticsearchClient.get(req -> req
                            .index("systemuser")
                            .id(String.valueOf(61064090)),
                    SystemUserDto.class);
            elasticLogger.debug(response.toString());
        } catch (IOException e) {
            elasticLogger.debug(e.getMessage());
        }
    }
}
