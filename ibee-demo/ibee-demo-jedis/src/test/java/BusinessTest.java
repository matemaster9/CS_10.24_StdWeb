import cs.matemaster.demo.jedis.JedisApplication;
import cs.matemaster.demo.jedis.constant.SystemConstants;
import cs.matemaster.demo.jedis.domain.EsportPlayer;
import cs.matemaster.demo.jedis.domain.LoginUserVO;
import cs.matemaster.jackson.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.HashMap;
import java.util.Map;

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
        jedisClient.set("EsportPlayer:" + esportPlayer.getName(), JacksonUtil.serialize(esportPlayer));
    }


    @Test
    public void add_v1() {
        LoginUserVO loginUser = new LoginUserVO();
        loginUser.setUsername("eric");
        loginUser.setPassword("l4TrhB0H");

        jedisClient.set(SystemConstants.RedisLoginUser + ":" + loginUser.getUsername(), JacksonUtil.serialize(loginUser), new SetParams().ex(60 * 60));
    }

    @Test
    public void del() {
        Long result = jedisClient.del(SystemConstants.RedisLoginUser + ":" + "eric");
        System.out.println(result);
    }

    @Test
    public void hSet() {

        LoginUserVO loginUser = new LoginUserVO();
        loginUser.setUsername("master");
        loginUser.setPassword("l4TrhB0H");

        Long result = jedisClient.hset(SystemConstants.RedisLoginUser + ":" + loginUser.getUsername(), new HashMap<String, String>() {{
            put("username", loginUser.getUsername());
            put("password", loginUser.getPassword());
        }});

        System.out.println(result);
    }

    @Test
    public void hGet() {
        String key = SystemConstants.RedisLoginUser + ":" + "master";
        Map<String, String> map = jedisClient.hgetAll(key);
        System.out.println(map);

        String username = jedisClient.hget(key, "username");
        String password = jedisClient.hget(key, "password");
        System.out.println(username);
        System.out.println(password);
    }

    @Test
    public void hDel() {
        Long result1 = jedisClient.hdel(SystemConstants.RedisLoginUser + ":" + "master", "username");
        Long result2 = jedisClient.hdel(SystemConstants.RedisLoginUser + ":" + "master", "password");
        System.out.println(result1);
        System.out.println(result2);
    }
}
