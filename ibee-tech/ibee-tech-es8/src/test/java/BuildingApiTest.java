import cs.matemaster.tech.es8.model.SystemManager;
import cs.matemaster.tech.es8.model.Developer;
import org.junit.Test;

/**
 * @author matemaster
 */
public class BuildingApiTest {

    @Test
    public void test() {
        Developer<SystemManager> developer = Developer.of(builder -> builder
                .name("MateMaster")
                .age(24)
                .job("系统开发")
                .project(new SystemManager("后台管理系统范例", "后台通用功能"))
        );

        System.out.println(developer);
    }
}
