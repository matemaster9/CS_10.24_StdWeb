import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.TermsQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.TermsQueryField;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.json.JsonData;
import cs.matemaster.tech.es8.config.ElasticConstant;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
public class QueryDSLTest {

    @Test
    public void term() {
        TermQuery termQuery = TermQuery.of(builder -> builder
                .field("username")
                .value("Matemaster")
        );

        Query query = Query.of(builder -> builder.term(termQuery));
        Query term = QueryBuilders.term(termQ -> termQ
                .field("username")
                .value("Matemaster")
        );
        System.out.println(termQuery);
        System.out.println(query);
        System.out.println(term);

        SearchRequest searchRequest = SearchRequest.of(builder -> builder
                .index("systemuser")
                .query(term)
        );
        System.out.println(searchRequest);
    }

    @Test
    public void terms() {
        List<String> values = Arrays.asList("bvw32iu388", "v2hg234", "9w28e4h9uv");
        List<FieldValue> fieldValues = values.stream().map(FieldValue::of).collect(Collectors.toList());
        TermsQueryField termsQueryField = TermsQueryField.of(builder1 -> builder1.value(fieldValues));
        TermsQuery termsQuery = TermsQuery.of(builder -> builder.field("_id").terms(termsQueryField));

        Query query = Query.of(builder -> builder.terms(termsQuery));
        Query terms = QueryBuilders.terms(builder -> builder.field("_id").terms(termsQueryField));

        System.out.println(termsQuery);
        System.out.println(query);
        System.out.println(terms);

        SearchRequest searchRequest = SearchRequest.of(builder -> builder
                .index("systemuser")
                .query(terms)
        );
        System.out.println(searchRequest);
    }

    @Test
    public void terms_v5() {
        List<String> values = Arrays.asList("bvw32iu388", "v2hg234", "9w28e4h9uv");

        TermsQuery termsQuery = TermsQuery.of(builder -> builder
                .field("_id")
                .terms(termsQField -> termsQField.value(values.stream().map(FieldValue::of).collect(Collectors.toList())))
        );

        Query terms = QueryBuilders.terms(termsQ -> termsQ
                .field("_id")
                .terms(termsQField -> termsQField.value(values.stream().map(FieldValue::of).collect(Collectors.toList())))
        );

        SearchRequest request = SearchRequest.of(req -> req
                .index(ElasticConstant.BankAccount)
                .query(terms)
        );

        System.out.println(request);
    }

    @Test
    public void bool() {

        BoolQuery boolQuery = BoolQuery.of(builder -> builder
                .must(QueryBuilders.term(termQ -> termQ.field("accountId.keyword").value("M100")))
                .must(QueryBuilders.term(termQ -> termQ.field("accountId.keyword").value("M999")))
                .minimumShouldMatch("1")
        );

        Query bool = QueryBuilders.bool(boolQ -> boolQ
                .must(QueryBuilders.term(termQ -> termQ.field("accountId.keyword").value("M100")))
                .must(QueryBuilders.term(termQ -> termQ.field("accountId.keyword").value("M999")))
                .minimumShouldMatch("1")
        );

        SearchRequest request = SearchRequest.of(req -> req
                .index(ElasticConstant.BankAccount)
                .query(bool)
        );

        System.out.println(boolQuery);
        System.out.println(request);
    }

    @Test
    public void match() {
        MatchQuery matchQuery = MatchQuery.of(builder -> builder
                .field("accountId")
                .query("M100")
        );

        Query match = QueryBuilders.match(matchQ -> matchQ
                .field("accountId")
                .query("M100")
        );

        SearchRequest request = SearchRequest.of(req -> req
                .index(ElasticConstant.BankAccount)
                .query(match)
        );

        System.out.println(matchQuery);
        System.out.println(request);
    }


    @Test
    public void matchAll() {

        MatchAllQuery matchAllQuery = MatchAllQuery.of(builder -> builder.boost(1.0f));
        Query matchAll = QueryBuilders.matchAll(matchAllQ -> matchAllQ.boost(1.0f));
        SearchRequest request = SearchRequest.of(req -> req.index(ElasticConstant.BankAccount).query(matchAll));

        System.out.println(matchAllQuery);
        System.out.println(request);
    }

    @Test
    public void range() {
        RangeQuery rangeQuery = RangeQuery.of(builder -> builder
                .field("amount")
                .lte(JsonData.of(BigDecimal.valueOf(40000.0)))
                .gte(JsonData.of(BigDecimal.valueOf(100000.0)))
        );

        Query range = QueryBuilders.range(rangeQ -> rangeQ
                .field("amount")
                .gte(JsonData.of(BigDecimal.valueOf(100000.0)))
                .lte(JsonData.of(BigDecimal.valueOf(400000.0)))
        );

        SearchRequest request = SearchRequest.of(req -> req
                .index(ElasticConstant.BankAccount)
                .query(range)
        );

        System.out.println(rangeQuery);
        System.out.println(request);
    }

    @Test
    public void multiMatch() {

    }

    @Test
    public void matchPhrase() {

    }

    @Test
    public void prefix() {

    }
}
