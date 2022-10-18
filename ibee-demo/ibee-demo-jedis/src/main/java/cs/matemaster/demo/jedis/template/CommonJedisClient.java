package cs.matemaster.demo.jedis.template;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * @author matemaster
 */
@Component
@AllArgsConstructor
public class CommonJedisClient extends AbstractJedisClient {


    private final Jedis jedisClient;

    @Override
    Jedis getJedisClient() {
        return jedisClient;
    }
}
