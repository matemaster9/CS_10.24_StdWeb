package cs.matemaster.config.redis;

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
public class RedisConfig {

    private RedisYaml redisYaml;

    @Bean
    public Jedis jedisClient() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setLifo(redisYaml.getInfo());
        config.setMaxIdle(redisYaml.getMaxIdle());
        config.setMinIdle(redisYaml.getMinIdle());
        config.setMaxTotal(redisYaml.getMaxTotal());
        config.setFairness(redisYaml.getFairness());
        config.setJmxEnabled(redisYaml.getJmxEnabled());
        config.setTestWhileIdle(redisYaml.getTestWhileIdle());
        config.setBlockWhenExhausted(redisYaml.getBlockWhenExhausted());

        try (JedisPool jedisPool = new JedisPool(config, redisYaml.getHost(), redisYaml.getPort(), 2000, redisYaml.getPassword())) {
            return jedisPool.getResource();
        }
    }
}
