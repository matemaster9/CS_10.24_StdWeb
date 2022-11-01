package cs.matemaster.tech.es8.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Month;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matemaster
 */
@Getter
@Builder
@ToString
public class CollegeStudent {
    private String studentId;
    private Boolean sex;
    private YearMonth start;
    private YearMonth finish;
    private Integer age;
    private String major;
    private String education;

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static List<CollegeStudent> mock() {
        return Stream.generate(CollegeStudent::singleton).limit(1000).collect(Collectors.toList());
    }

    private static CollegeStudent singleton() {
        String[] majorArr = {"计算机科学与技术", "人工智能", "软件工程", "大数据科学与技术"};
        String majorStr = majorArr[random.nextInt(0, majorArr.length)];
        int[] academicSystem = {3, 4, 7, 12};
        Map<Integer, String> academicSystemMap = new HashMap<Integer, String>() {{
            put(3, "专科");
            put(4, "本科");
            put(7, "硕士");
            put(12, "博士");
        }};
        int schoolYear = academicSystem[random.nextInt(0, academicSystem.length)];
        YearMonth startY = YearMonth.of(random.nextInt(2012, 2022), Month.SEPTEMBER);
        YearMonth finishY = startY.plusYears(schoolYear);

        return CollegeStudent.builder()
                .studentId("Stu" + random.nextInt(10_000_000, 99_999_999))
                .sex(random.nextBoolean())
                .start(startY)
                .finish(finishY)
                .age(18 + schoolYear)
                .major(majorStr)
                .education(academicSystemMap.get(schoolYear))
                .build();
    }
}
