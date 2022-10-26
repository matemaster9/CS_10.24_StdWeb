package cs.matemaster.demo.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author matemaster
 */
@Configuration
public class ElasticConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestClientBuilder clientBuilder = RestClient.builder(new HttpHost("10.37.129.102", 9200, "http"));
        return new RestHighLevelClient(clientBuilder);
    }
}
