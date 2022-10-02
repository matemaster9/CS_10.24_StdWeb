import cs.matemaster.demo.config.ExternalizedConfigApplication;
import cs.matemaster.demo.config.externalize.ConstructorBingingConfig;
import cs.matemaster.demo.config.externalize.MultiConstructorBingingConfig;
import cs.matemaster.demo.config.externalize.RandomValueConfig;
import cs.matemaster.demo.config.externalize.StandardConfig;
import cs.matemaster.demo.config.externalize.YmlConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author matemaster
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExternalizedConfigApplication.class)
public class SpringWebTest {

    public SpringWebTest() {
    }

    @Autowired
    private RandomValueConfig randomValueConfig;

    @Autowired
    private StandardConfig standardConfig;

    @Autowired
    private ConstructorBingingConfig constructorBingingConfig;

    @Autowired
    private MultiConstructorBingingConfig multiConstructorBingingConfig;

    @Autowired
    private YmlConf ymlConf;

    @Test
    public void test() {
        System.out.println(randomValueConfig);
        System.out.println(standardConfig);
        System.out.println(constructorBingingConfig);
        System.out.println(multiConstructorBingingConfig);
        System.out.println(ymlConf);
    }
}
