package cs.matemaster.boot.jedis.template;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
@AllArgsConstructor
public class EnhancedRedisTemplate {

    private CommonJedisClient commonJedisClient;

    public void set(String key, String message) {
        commonJedisClient.set(key, message);
    }

    public String get(String key) {
        return commonJedisClient.get(key);
    }
}
