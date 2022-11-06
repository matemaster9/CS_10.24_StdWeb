package cs.matemaster.boot.jedis.template;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Map;

/**
 * @author matemaster
 */
@Component
@AllArgsConstructor
public class EnhancedRedisTemplate {

    private static final Logger logger = LoggerFactory.getLogger(EnhancedRedisTemplate.class);

    private Jedis jedisClient;

    private static final String Delimiter = ":";

    private String getPrefixKey(String prefix, String key) {
        return String.join(Delimiter, prefix, key);
    }

    public void setString2Redis(String prefix, String key, String value) {
        String redisKey = getPrefixKey(prefix, key);
        jedisClient.set(redisKey, value);
        logger.debug("存储数据至redis成功" + redisKey);
    }

    public String getStringFromRedis(String prefix, String key) {
        return jedisClient.get(getPrefixKey(prefix, key));
    }

    public void setExpiredString2Redis(String prefix, String key, String value, int secondsToExpire) {
        String redisKey = getPrefixKey(prefix, key);
        jedisClient.set(redisKey, value, SetParams.setParams().ex(secondsToExpire));
        logger.debug("存储数据至redis成功" + redisKey);
    }

    public void setString2Redis(String prefix, String key, String value, SetParams setParams) {
        String redisKey = getPrefixKey(prefix, key);
        jedisClient.set(redisKey, value, setParams);
        logger.debug("存储数据至redis成功" + redisKey);
    }

    public void setHash2Redis(String prefix, String key, Map<String, String> hash) {
        String redisKey = getPrefixKey(prefix, key);
        jedisClient.hset(redisKey, hash);
        logger.debug("存储数据至redis成功" + redisKey);
    }

    public Map<String, String> getAllHashFromRedis(String prefix, String key) {
        String redisKey = getPrefixKey(prefix, key);
        return jedisClient.hgetAll(redisKey);
    }

    public String getHashFieldFromRedis(String prefix, String key, String field) {
        String redisKey = getPrefixKey(prefix, key);
        return jedisClient.hget(redisKey, field);
    }
}
