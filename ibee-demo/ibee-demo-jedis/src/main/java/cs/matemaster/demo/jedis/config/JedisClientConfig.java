package cs.matemaster.demo.jedis.config;


import cs.matemaster.demo.jedis.template.CommonJedisClient;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author matemaster
 */
@Configuration
@AllArgsConstructor
public class JedisClientConfig {

    private JedisProperties properties;

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(redisConnectionFactory);

        // 设置key的序列化策略
        template.setKeySerializer(new StringRedisSerializer());
        // 设置value的序列化策略
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));

        return template;
    }

    @Bean
    public Jedis jedisClient() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setLifo(properties.getInfo());
        config.setMaxIdle(properties.getMaxIdle());
        config.setMinIdle(properties.getMinIdle());
        config.setMaxTotal(properties.getMaxTotal());
        config.setFairness(properties.getFairness());
        config.setJmxEnabled(properties.getJmxEnabled());
        config.setTestWhileIdle(properties.getTestWhileIdle());
        config.setBlockWhenExhausted(properties.getBlockWhenExhausted());

        try (JedisPool jedisPool = new JedisPool(config, properties.getHost(), properties.getPort(), 2000, properties.getPassword())) {
            return jedisPool.getResource();
        }
    }

    @Bean
    public CommonJedisClient commonJedisClient() {
        return new CommonJedisClient(jedisClient());
    }
}
