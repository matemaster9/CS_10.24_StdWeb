import cs.matemaster.tech.es8.model.CollegeStudent;
import org.junit.Test;

import java.util.List;

/**
 * @author matemaster
 */
public class MockTest {


    @Test
    public void name() {
        List<CollegeStudent> mock = CollegeStudent.mock();
        mock.forEach(System.out::println);
    }
}
