import cs.matemaster.demo.jedis.JedisApplication;
import cs.matemaster.demo.jedis.domain.EsportPlayer;
import cs.matemaster.jackson.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JedisApplication.class)
public class BusinessTest {

    @Autowired
    private Jedis jedisClient;

    @Test
    public void add() {
        EsportPlayer esportPlayer = EsportPlayer.mock();
        jedisClient.set("EsportPlayer:" + esportPlayer.getName() , JacksonUtil.serialize(esportPlayer));
    }
}
