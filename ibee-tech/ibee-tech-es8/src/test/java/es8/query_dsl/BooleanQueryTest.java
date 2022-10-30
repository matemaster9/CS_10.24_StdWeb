package es8.query_dsl;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.json.JsonData;
import org.junit.Test;

/**
 * @author matemaster
 */
public class BooleanQueryTest {

    @Test
    public void bool() {

        Query bool = QueryBuilders.bool(boolQ -> boolQ
                .boost(1.0F)
                .minimumShouldMatch("1")
                .must(QueryBuilders.term(builder -> builder.field("user.id").value("kimchy")))
                .filter(QueryBuilders.term(builder -> builder.field("tags").value("production")))
                .mustNot(QueryBuilders.range(builder -> builder.field("age").gte(JsonData.of(10)).lte(JsonData.of(20))))
                .should(
                        QueryBuilders.term(builder -> builder.field("tags").value("env1")),
                        QueryBuilders.term(builder -> builder.field("tags").value("deployed"))
                )
        );

        SearchRequest request = SearchRequest.of(builder -> builder.query(bool));
        System.out.println(request);
    }

    @Test
    public void scoringWithBoolFilter() {
        Query bool1 = QueryBuilders.bool(boolQ -> boolQ.filter(QueryBuilders.term(builder -> builder.field("status").value("active"))));
        Query bool2 = QueryBuilders.bool(boolQ -> boolQ
                .must(QueryBuilders.matchAll().build()._toQuery())
                .filter(QueryBuilders.term(builder -> builder.field("status").value("active")))
        );
        Query constantScore = QueryBuilders.constantScore(builder -> builder
                .filter(QueryBuilders.term(termQ -> termQ.field("status").value("active")))
        );

        System.out.println(bool1);
        System.out.println(bool2);
        System.out.println(constantScore);
    }


    /**
     * 命名查询
     */
    @Test
    public void namedQuery() {

    }
}
