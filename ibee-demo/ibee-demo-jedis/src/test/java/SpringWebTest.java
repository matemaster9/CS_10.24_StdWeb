import cs.matemaster.demo.jedis.JedisApplication;
import cs.matemaster.demo.jedis.domain.EsportPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Test
    public void add() {
        EsportPlayer esportPlayer = EsportPlayer.mock();
        redisTemplate.opsForValue().set("Esport_" + esportPlayer.getName(), esportPlayer);
    }
}
