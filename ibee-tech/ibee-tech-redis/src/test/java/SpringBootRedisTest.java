import cs.matemaster.jackson.JacksonUtil;
import cs.matemaster.tech.redis.RedisApplication;
import cs.matemaster.tech.redis.domain.SystemUserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class SpringBootRedisTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String SYSTEM_USER = "SystemUser";

    @Test
    public void addUser() {
        SystemUserDto mockUser = SystemUserDto.mock();
        String keyHasPrefix = SYSTEM_USER + mockUser.getCode();
        redisTemplate.opsForValue().set(keyHasPrefix, Objects.requireNonNull(JacksonUtil.serialize(mockUser)));
    }

    @Test
    public void addUser_v2() {
        SystemUserDto mockUser = SystemUserDto.mock();
        String keyHasPrefix = SYSTEM_USER + mockUser.getCode();
        stringRedisTemplate.opsForValue().set(keyHasPrefix, Objects.requireNonNull(JacksonUtil.serialize(mockUser)));
    }
}
