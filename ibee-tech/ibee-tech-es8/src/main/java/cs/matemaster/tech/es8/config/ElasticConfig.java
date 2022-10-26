package cs.matemaster.tech.es8.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;


/**
 * @author matemaster
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class ElasticConfig {

    private ElasticYml elasticYml;

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        RestClient restClient = RestClient
                .builder(new HttpHost(elasticYml.getAddress(), elasticYml.getPort(), elasticYml.getScheme()))
                .setHttpClientConfigCallback(getHttpClientConfigCallback())
                .build();
        RestClientTransport restClientTransport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        return new ElasticsearchClient(restClientTransport);
    }

    public RestClientBuilder.HttpClientConfigCallback getHttpClientConfigCallback() {
        return httpAsyncClientBuilder -> {
            // 配置es 用户密码认证
            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(elasticYml.getUsername(), elasticYml.getPassword()));
            httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider);

            // 配置es ssl访问
            final SSLContext sslContext;
            try {
                // 信任所有
                sslContext = SSLContexts.custom().loadTrustMaterial(null, (x509Certificates, s) -> true).build();
            } catch (Exception e) {
                log.debug(e.getMessage());
                return null;
            }
            httpAsyncClientBuilder.setSSLContext(sslContext);
            return httpAsyncClientBuilder;
        };
    }
}
