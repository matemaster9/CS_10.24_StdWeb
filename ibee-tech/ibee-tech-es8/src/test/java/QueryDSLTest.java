import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import org.junit.Test;

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
