import co.elastic.clients.elasticsearch.core.IndexRequest;
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
}
