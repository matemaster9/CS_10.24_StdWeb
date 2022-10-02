import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.matemaster.demo.jackson.domain.enums.DiyEnum;
import cs.matemaster.demo.jackson.domain.enums.ErrorCode;
import cs.matemaster.demo.jackson.domain.enums.MyEnum;
import cs.matemaster.demo.jackson.domain.enums.ProductCode;
import org.junit.Test;

/**
 * @author matemaster
 */
public class EnumTestCase {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void case1() throws JsonProcessingException {
        String value = OBJECT_MAPPER.writeValueAsString(ErrorCode.UNKNOWN);
        System.out.println(value);
    }


    @Test
    public void case2() throws JsonProcessingException {
        String value = OBJECT_MAPPER.writeValueAsString(ProductCode.PC);
        System.out.println(value);

        ProductCode productCode = OBJECT_MAPPER.readValue(value, ProductCode.class);
        System.out.println(productCode);
    }

    @Test
    public void case3() throws JsonProcessingException {
        String value = OBJECT_MAPPER.writeValueAsString(MyEnum.EXAMPLE);
        System.out.println(value);
    }

    @Test
    public void case4() throws JsonProcessingException {
        String jsonContent = "{\"code\":\"ERR0000\",\"message\":\"未知错误\"}";
        ErrorCode errorCode = OBJECT_MAPPER.readValue(jsonContent, ErrorCode.class);
        System.out.println(errorCode);
    }

    @Test
    public void case5() throws JsonProcessingException {
        String jsonContent = "{\"code\":\"EX8789\",\"message\":\"案例\"}";
        MyEnum myEnum = OBJECT_MAPPER.readValue(jsonContent, MyEnum.class);
        System.out.println(myEnum);
    }

    @Test
    public void case6() throws JsonProcessingException {
        String diy = OBJECT_MAPPER.writeValueAsString(DiyEnum.DIY);
        System.out.println(diy);

        DiyEnum diyEnum = OBJECT_MAPPER.readValue(diy, DiyEnum.class);
        System.out.println(diyEnum);
    }
}
