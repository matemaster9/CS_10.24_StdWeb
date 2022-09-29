import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import cs.matemaster.demo.jackson.ComStaff;
import cs.matemaster.demo.jackson.JsonUtil;
import cs.matemaster.demo.jackson.StaffWorkLog;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matemaster
 */
public class JacksonTest {

    @Test
    public void case1() {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        ComStaff comStaff = new ComStaff();
        comStaff.setCode(localRandom.nextInt());
        comStaff.setName("mate-master");
        comStaff.setSex(localRandom.nextBoolean());
        String serialize = JsonUtil.serialize(comStaff);
        System.out.println(serialize);
    }


    @Test
    public void case2() {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        ComStaff comStaff = new ComStaff();
        comStaff.setCode(localRandom.nextInt());
        comStaff.setSex(localRandom.nextBoolean());
        String serialize = JsonUtil.serializeIgnoreNull(comStaff);
        System.out.println(serialize);
    }

    @Test
    public void case3() {
        String jsonStr = "{\"code\":-1479974958,\"sex\":false}";
        ComStaff deserialize = JsonUtil.deserialize(jsonStr, ComStaff.class);
        System.out.println(deserialize);
    }

    @Test
    public void case4() {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        List<ComStaff> comStaffList = Stream.generate(() -> {
            ComStaff comStaff = new ComStaff();
            comStaff.setSex(localRandom.nextBoolean());
            comStaff.setName("mate-master");
            comStaff.setCode(localRandom.nextInt());
            return comStaff;
        }).limit(10).collect(Collectors.toList());

        String serialize = JsonUtil.serialize(comStaffList);
        List<ComStaff> deserialize = JsonUtil.deserialize(serialize, new TypeReference<List<ComStaff>>() {
        });
        deserialize.forEach(System.out::println);
    }

    @Test
    public void case5() {
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();
        List<ComStaff> comStaffList = Stream.generate(() -> {
            ComStaff comStaff = new ComStaff();
            comStaff.setSex(localRandom.nextBoolean());
            comStaff.setName("mate-master");
            comStaff.setCode(localRandom.nextInt());
            return comStaff;
        }).limit(10).collect(Collectors.toList());

        Map<Boolean, List<ComStaff>> comStaffMap = comStaffList.stream().collect(Collectors.partitioningBy(ComStaff::getSex));

        String serialize = JsonUtil.serialize(comStaffMap);
        System.out.println(serialize);
        Map<Boolean, List<ComStaff>> deserialize = JsonUtil.deserialize(serialize, new TypeReference<Map<Boolean, List<ComStaff>>>() {
        });

        System.out.println(deserialize.get(true));
        System.out.println(deserialize.get(false));
    }


    @Test
    public void jsonTree() throws JsonProcessingException {
        String jsonContent = "{\"took\":2,\"timed_out\":false,\"_shards\":{\"total\":5,\"successful\":5,\"skipped\":0,\"failed\":0},\"hits\":{\"total\":3,\"max_score\":1,\"hits\":[{\"_index\":\"music\",\"_type\":\"children\",\"_id\":\"2\",\"_score\":1,\"_source\":{\"name\":\"wake me, shark me\",\"content\":\"don't let me sleep too late, gonna get up brightly early in the morning\",\"language\":\"english\",\"length\":\"55\",\"likes\":9}}]}}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonContent);
        Iterator<String> iterator = jsonNode.fieldNames();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        JsonNode hits = jsonNode.get("hits");
        System.out.println(hits.toPrettyString());
    }

    @Test
    public void case6() throws JsonProcessingException {
        StaffWorkLog workLog = new StaffWorkLog();
        workLog.setCode("mate-master");
        workLog.setOnDuty(LocalDateTime.now());
        workLog.setOffDuty(LocalDateTime.now().plusDays(1L));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        String jsonContent = objectMapper.writeValueAsString(workLog);
        System.out.println(jsonContent);
    }
}
