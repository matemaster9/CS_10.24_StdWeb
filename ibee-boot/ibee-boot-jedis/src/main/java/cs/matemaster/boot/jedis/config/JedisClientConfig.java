package cs.matemaster.boot.jedis.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author matemaster
 */
@Configuration
@AllArgsConstructor
public class JedisClientConfig {

    private BootJedisClientConfig bootJedisClientConfig;

    @Bean("jedisClient")
    public Jedis getJedisClient() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(bootJedisClientConfig.getMaxTotal());

        try (JedisPool jedisPool = new JedisPool(config)) {
            return jedisPool.getResource();
        }
    }
}
