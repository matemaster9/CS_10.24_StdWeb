package cs.matemaster.tech.es8.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import cs.matemaster.tech.es8.config.ElasticConstants;
import cs.matemaster.tech.es8.model.CollegeStudent;
import cs.matemaster.tech.es8.service.CollegeStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@Service
@AllArgsConstructor
public class CollegeStudentServiceImpl implements CollegeStudentService {

    private ElasticsearchClient elasticsearchClient;

    @Override
    public void mock() throws IOException {
        List<CollegeStudent> collegeStudentList = CollegeStudent.mock();
        List<BulkOperation> bulkOperations = collegeStudentList.stream()
                .map(collegeStudent -> BulkOperation.of(bulkOperationBuilder -> bulkOperationBuilder
                        .index(indexOperationBuilder -> indexOperationBuilder
                                .index(ElasticConstants.CollegeStudentIndex)
                                .id(collegeStudent.getStudentId())
                                .document(collegeStudent)))
                ).collect(Collectors.toList());

        BulkRequest bulkRequest = BulkRequest.of(builder -> builder.operations(bulkOperations));
        elasticsearchClient.bulk(bulkRequest);
    }
}
