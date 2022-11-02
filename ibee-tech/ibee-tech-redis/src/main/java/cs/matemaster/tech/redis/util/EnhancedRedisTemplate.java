package cs.matemaster.tech.redis.util;

import io.lettuce.core.RedisClient;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
@AllArgsConstructor
public class EnhancedRedisTemplate {

    private RedisClient redisClient;

    public EnhancedRedisTemplate() {
    }


    public void saveMessage2Redis() {

    }

}
