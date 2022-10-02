import cs.matemaster.demo.config.ExternalizedConfigApplication;
import cs.matemaster.demo.config.externalize.ConstructorBingingConfig;
import cs.matemaster.demo.config.externalize.MultiConstructorBingingConfig;
import cs.matemaster.demo.config.externalize.RandomValueConfig;
import cs.matemaster.demo.config.externalize.StandardConfig;
import cs.matemaster.demo.config.externalize.ThirdPartyConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
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

    @Bean
    @ConfigurationProperties(prefix = "third-party-configuration")
    public ThirdPartyConfiguration thirdPartyConfiguration() {
        return new ThirdPartyConfiguration();
    }

    @Test
    public void test() {
        System.out.println(randomValueConfig);
        System.out.println(standardConfig);
        System.out.println(constructorBingingConfig);
        System.out.println(multiConstructorBingingConfig);
    }
}
