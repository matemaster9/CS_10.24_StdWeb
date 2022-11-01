package es8;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import cs.matemaster.tech.es8.ElasticApplication;
import cs.matemaster.tech.es8.config.ElasticConstant;
import cs.matemaster.tech.es8.model.BankAccount;
import cs.matemaster.tech.es8.service.CollegeStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticApplication.class)
public class ESApp {
    private static final Logger elasticLogger = LoggerFactory.getLogger(ESApp.class);

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Autowired
    private CollegeStudentService collegeStudentService;

    /**
     * 将M100~M999的账户数据存放es
     */
    @Test
    public void mock() {
        List<BankAccount> bankAccounts = new ArrayList<>(900);
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        for (int i = 100; i < 1000; i++) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccountId("M" + i);
            bankAccount.setAmount(BigDecimal.valueOf(localRandom.nextDouble(0.0, 1000000.0000)));
            bankAccounts.add(bankAccount);
        }

        List<BulkOperation> bulkOperationList = bankAccounts.stream().map(it -> BulkOperation.of(
                        bulkOperationBuilder -> bulkOperationBuilder.index(
                                indexOperationBuilder -> indexOperationBuilder
                                        .index(ElasticConstant.BankAccountIndex)
                                        .id(it.getAccountId())
                                        .document(it))
                )
        ).collect(Collectors.toList());
        BulkRequest bulkRequest = BulkRequest.of(builder -> builder.operations(bulkOperationList));

        try {
            BulkResponse bulkResponse = elasticsearchClient.bulk(bulkRequest);
            elasticLogger.info(bulkRequest.toString());
            elasticLogger.info(bulkResponse.toString());
        } catch (IOException e) {
            elasticLogger.error(e.getMessage());
        }
    }

    /**
     * 依据文档id直接查询文档存放实例对象
     */
    @Test
    public void getAccountByDocId() {
        try {
            GetResponse<BankAccount> response = elasticsearchClient.get((builder -> builder
                            .index(ElasticConstant.BankAccountIndex)
                            .id("M100")),
                    BankAccount.class
            );

            elasticLogger.info(response.toString());
            elasticLogger.info(response.source().toString());
            elasticLogger.info(response.fields().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * text查出结果为空？存疑？？？？？
     * keyword查询m100
     */
    @Test
    public void termAccountId() {
        SearchRequest request = SearchRequest.of(builder -> builder
                .index(ElasticConstant.BankAccountIndex)
                .query(QueryBuilders.term(termQ -> termQ.field("accountId.keyword").value("M100")))
        );

        try {
            SearchResponse<BankAccount> response = elasticsearchClient.search(request, BankAccount.class);
            elasticLogger.info(request.toString());
            elasticLogger.info(response.toString());
            elasticLogger.info(response.hits().hits().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void match() {
        SearchRequest request = SearchRequest.of(builder -> builder
                .index(ElasticConstant.BankAccountIndex)
                .query(QueryBuilders.match(matchQ -> matchQ.field("accountId").query("M100")))
        );

        try {
            SearchResponse<BankAccount> response = elasticsearchClient.search(request, BankAccount.class);
            elasticLogger.info(request.toString());
            elasticLogger.info(response.toString());
            elasticLogger.info(response.hits().hits().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void name() throws IOException {
        collegeStudentService.mock();
    }
}
