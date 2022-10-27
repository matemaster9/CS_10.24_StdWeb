import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.TermsQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.TermsQueryField;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import org.junit.Test;

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
        Query term = QueryBuilders.term(builder -> builder
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
    public void bool() {

    }

    @Test
    public void match() {

    }


    @Test
    public void matchAll() {

    }

    @Test
    public void range() {

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
