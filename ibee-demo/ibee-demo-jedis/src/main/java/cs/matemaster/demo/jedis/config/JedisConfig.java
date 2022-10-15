package cs.matemaster.demo.jedis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author matemaster
 */
@Configuration
public class JedisConfig {

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
}
