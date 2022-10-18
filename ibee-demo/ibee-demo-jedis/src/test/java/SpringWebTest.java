import cs.matemaster.demo.jedis.JedisApplication;
import cs.matemaster.demo.jedis.domain.EsportPlayer;
import cs.matemaster.demo.jedis.template.CommonJedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JedisApplication.class)
public class SpringWebTest {

    private static Logger logger = LoggerFactory.getLogger(SpringWebTest.class);

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private CommonJedisClient commonJedisClient;

    @Test
    public void add() {
        EsportPlayer esportPlayer = EsportPlayer.mock();
        redisTemplate.opsForValue().set("Esport_" + esportPlayer.getName(), esportPlayer);
    }

    @Test
    public void get() {
        Object esport = redisTemplate.opsForValue().get("Esport_3770735482659699292");
        logger.info(esport.toString());
    }

    @Test
    public void jedisClientTest() {
        commonJedisClient.set("st","system","macos");
    }
}
