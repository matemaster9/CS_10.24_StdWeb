import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import cs.matemaster.demo.jackson.domain.ClubMemberVO;
import cs.matemaster.demo.jackson.domain.CompanyDto;
import cs.matemaster.demo.jackson.domain.ComputerBriefDto;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author matemaster
 */
public class JsonTestCase {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * ObjectMapper是否可以序列化null
     *
     * @throws JsonProcessingException
     */
    @Test
    public void case1() throws JsonProcessingException {
        String result = OBJECT_MAPPER.writeValueAsString(null);
        System.out.println(result);
    }

    /**
     * 自定义json字符串属性名称@JsonProperty
     *
     * @throws JsonProcessingException
     */
    @Test
    public void case2() throws JsonProcessingException {
        CompanyDto company = new CompanyDto();
        company.setName("Alibaba");
        company.setFounder("JackMa");
        company.setFoundDate(LocalDate.of(1999, 6, 28));
        company.setMarketValue(BigDecimal.valueOf(2028.26D));
        company.setMainBusiness("电子商务");

        String result = OBJECT_MAPPER.writeValueAsString(company);
        System.out.println(result);

        JsonNode jsonNode = OBJECT_MAPPER.readTree(result);
        System.out.println(jsonNode.toPrettyString());
    }

    /**
     * 自定义单个类的命名策略@JsonNaming
     *
     * @throws JsonProcessingException
     */
    @Test
    public void case3() throws JsonProcessingException {
        ClubMemberVO clubMemberVO = new ClubMemberVO();
        clubMemberVO.setMemberId("M809672");
        clubMemberVO.setMemberName("MateMaster");
        clubMemberVO.setMemberSex(Boolean.TRUE);
        clubMemberVO.setMemberRank(1);

        String result = OBJECT_MAPPER.writeValueAsString(clubMemberVO);
        System.out.println(result);

        JsonNode jsonNode = OBJECT_MAPPER.readTree(result);
        System.out.println(jsonNode.toPrettyString());
    }

    /**
     * 利用objectMapper自定义命名策略，优先级
     *
     * @throws JsonProcessingException
     */
    @Test
    public void case4() throws JsonProcessingException {
        // 自定义蛇形命名策略
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        // objectMapper优先级小于@JsonNaming
        ClubMemberVO clubMemberVO = new ClubMemberVO();
        clubMemberVO.setMemberId("M809672");
        clubMemberVO.setMemberName("MateMaster");
        clubMemberVO.setMemberSex(Boolean.TRUE);
        clubMemberVO.setMemberRank(1);

        String priority = objectMapper.writeValueAsString(clubMemberVO);
        System.out.println(priority);

        System.out.println(objectMapper.readTree(priority).toPrettyString());

        // @JsonProperty不受命名策略影响
        CompanyDto company = new CompanyDto();
        company.setName("Alibaba");
        company.setFounder("JackMa");
        company.setFoundDate(LocalDate.of(1999, 6, 28));
        company.setMarketValue(BigDecimal.valueOf(2028.26D));
        company.setMainBusiness("电子商务");

        String diyNamingStrategy = objectMapper.writeValueAsString(company);
        System.out.println(diyNamingStrategy);

        System.out.println(objectMapper.readTree(diyNamingStrategy).toPrettyString());
    }

    /**
     * 利用objectMapper自定义命名策略
     *
     * @throws JsonProcessingException
     */
    @Test
    public void case5() throws JsonProcessingException {
        // 设置蛇形
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        ComputerBriefDto computerBriefDto = new ComputerBriefDto();
        computerBriefDto.setComputerBrand("Apple");
        computerBriefDto.setComputerModel("Mac Studio");

        String diyNamingStrategy = OBJECT_MAPPER.writeValueAsString(computerBriefDto);
        System.out.println(OBJECT_MAPPER.readTree(diyNamingStrategy).toPrettyString());
    }
}
