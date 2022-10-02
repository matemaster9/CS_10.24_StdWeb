import cs.matemaster.demo.config.ExternalizedConfigApplication;
import cs.matemaster.demo.config.yaml.LoginUser;
import cs.matemaster.demo.config.yaml.MacStudio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExternalizedConfigApplication.class)
public class SnakeYamlTest {

    @Autowired
    private LoginUser loginUser;

    @Autowired
    private MacStudio macStudio;

    @Test
    public void test1() {
        System.out.println(loginUser);
        System.out.println(macStudio);

        // snakeyaml的list底层使用 java.util.ArrayList
        List<String> roles = loginUser.getRoles();
        System.out.println(roles.getClass());

        // snakeyaml的map底层使用 java.util.LinkedHashMap
        Map<String, List<String>> resources = macStudio.getResources();
        System.out.println(resources.getClass());
    }
}
