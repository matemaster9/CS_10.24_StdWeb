import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.ingest.simulate.Document;
import co.elastic.clients.json.JsonData;
import cs.matemaster.tech.es8.model.BankAccount;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author matemaster
 */
public class DocTest {

    @Test
    public void test() {
        BankAccount myAccount = new BankAccount();
        myAccount.setAccountId("matemaster");
        myAccount.setAmount(BigDecimal.valueOf(10000.0));

        Document document = Document.of(builder -> builder.index("bank_account").id("1").source(JsonData.of(myAccount)));
        System.out.println(document);
    }

    @Test
    public void test2() {
        BankAccount myAccount = new BankAccount();
        myAccount.setAccountId("matemaster");
        myAccount.setAmount(BigDecimal.valueOf(10000.0));

        IndexRequest<BankAccount> indexRequest = IndexRequest.of(builder -> builder.index("bank_account").id("1").document(myAccount));
        System.out.println(indexRequest);
    }
}
