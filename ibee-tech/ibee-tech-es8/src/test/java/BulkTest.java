import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.bulk.IndexOperation;
import cs.matemaster.tech.es8.model.StaffWorkLogDto;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author matemaster
 */
public class BulkTest {

    @Test
    public void test1() {

        StaffWorkLogDto workLog1 = new StaffWorkLogDto();
        workLog1.setWorkingHours(8);
        workLog1.setStaffCode("99999999");
        workLog1.setOnDuty(LocalDateTime.of(2022, 10, 1, 8, 30));
        workLog1.setOffDuty(LocalDateTime.of(2022, 10, 1, 17, 30));

        StaffWorkLogDto workLog2 = new StaffWorkLogDto();
        workLog2.setWorkingHours(8);
        workLog2.setStaffCode("10000000");
        workLog2.setOnDuty(LocalDateTime.of(2022, 10, 2, 8, 30));
        workLog2.setOffDuty(LocalDateTime.of(2022, 10, 2, 17, 30));

        IndexOperation<Object> indexOperation1 = IndexOperation.of(builder -> builder
                .index("work-log")
                .id("2022-10-01")
                .document(workLog1)
        );

        IndexOperation<Object> indexOperation2 = IndexOperation.of(builder -> builder
                .index("work-log")
                .id("2022-10-02")
                .document(workLog2)
        );

        BulkOperation bulkOperation1 = BulkOperation.of(builder -> builder.index(indexOperation1));
        BulkOperation bulkOperation2 = BulkOperation.of(builder -> builder.index(indexOperation2));

        BulkRequest bulkRequest = BulkRequest.of(builder -> builder
                .operations(bulkOperation1, bulkOperation2)
        );

        System.out.println(bulkRequest);
    }
}
