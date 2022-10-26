package cs.matemaster.tech.redis.util;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
@AllArgsConstructor
public class EnhancedRedisTemplate {

    private RedisTemplate<String, Object> redisTemplate;

    public EnhancedRedisTemplate() {
    }


}
