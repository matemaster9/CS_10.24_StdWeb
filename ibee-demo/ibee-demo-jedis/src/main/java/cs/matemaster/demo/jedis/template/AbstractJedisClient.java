package cs.matemaster.demo.jedis.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @author matemaster
 */
public abstract class AbstractJedisClient {

    private static final Logger abstractLogger = LoggerFactory.getLogger(AbstractJedisClient.class);

    private static final String DELIMITER = ":";

    /**
     * 获取jedis实例
     *
     * @return
     */
    abstract Jedis getJedisClient();


    public String getBizKey(String prefix, String key) {
        return String.join(DELIMITER, prefix, key);
    }

    public void set(String prefix, String key, String value) {
        getJedisClient().set(getBizKey(prefix, key), value);
        abstractLogger.info("redis key-value存储成功");
    }

    public String get(String prefix, String key) {
        return getJedisClient().get(getBizKey(prefix, key));
    }
}
