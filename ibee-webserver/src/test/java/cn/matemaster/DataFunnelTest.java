package cn.matemaster;

import com.google.common.collect.Sets;
import cs.matemaster.mapstruct.IActivityDataFunnelMapper;
import cs.matemaster.model.dto.ActivityBaseInfoDto;
import cs.matemaster.model.dto.ActivityDataFunnel;
import cs.matemaster.model.dto.ActivityDataFunnelVO;
import cs.matemaster.model.dto.DataFunnelDto;
import cs.matemaster.model.dto.EquityDto;
import cs.matemaster.util.BusinessUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cs.matemaster.util.BusinessUtil.StdRandom;
import static cs.matemaster.util.BusinessUtil.getBizCode;

/**
 * @author matemaster
 */
@Slf4j
public class DataFunnelTest {

    @Test
    public void test1() {

        List<ActivityBaseInfoDto> activityBaseInfoList = mockActivityBaseInfo();
        List<String> collect = activityBaseInfoList.stream().limit(150_000).map(ActivityBaseInfoDto::getActivityId).collect(Collectors.toList());
        List<DataFunnelDto> dataFunnelList = mockDataFunnel(collect, collect.size());
        dataFunnelList.addAll(mockDataFunnel(Stream.generate(() -> getBizCode("ACT")).limit(40000).collect(Collectors.toList()), 40000));

        dataFunnelList.parallelStream().forEach(
                dataFunnelDto -> dataFunnelDto.setDate(LocalDate.of(2022, 10, StdRandom.nextInt(1, 31)))
        );

        Collections.shuffle(activityBaseInfoList, StdRandom);
        Collections.shuffle(dataFunnelList, StdRandom);

        long now = System.currentTimeMillis();

        if (CollectionUtils.isEmpty(activityBaseInfoList) || CollectionUtils.isEmpty(dataFunnelList)) {
            return;
        }

        Map<String, ActivityBaseInfoDto> activityBaseInfoMap = activityBaseInfoList.stream().collect(Collectors.toMap(ActivityBaseInfoDto::getActivityId, t -> t));
        Map<String, List<DataFunnelDto>> dataFunnelMap = dataFunnelList.stream().collect(Collectors.groupingBy(DataFunnelDto::getActivityId));

        Sets.SetView<String> intersection = Sets.intersection(activityBaseInfoMap.keySet(), dataFunnelMap.keySet());

        List<ActivityDataFunnel> activityDataFunnelList = intersection.parallelStream()
                .flatMap(activityId ->
                        dataFunnelMap.get(activityId).stream().map(item -> ActivityDataFunnel.getInstance(activityId, activityBaseInfoMap.get(activityId), item))
                ).collect(Collectors.toList());

        ActivityDataFunnel activityDataFunnel = activityDataFunnelList.get(0);
        ActivityDataFunnelVO activityDataFunnelVO = IActivityDataFunnelMapper.Instance.toActivityDataFunnelVO(activityDataFunnel);
        log.debug(activityDataFunnelVO.toString());

        log.debug("过程耗时：" + (System.currentTimeMillis() - now));
    }

    private List<ActivityBaseInfoDto> mockActivityBaseInfo() {
        return Stream.generate(() -> {
                    ActivityBaseInfoDto activityBaseInfo = new ActivityBaseInfoDto();
                    activityBaseInfo.setActivityId(BusinessUtil.getBizCode("ACT"));
                    return activityBaseInfo;
                }).limit(200_000)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<DataFunnelDto> mockDataFunnel(List<String> activityIdList, int capacity) {
        return activityIdList.parallelStream()
                .map(activityId -> {
                    DataFunnelDto dataFunnel = new DataFunnelDto();
                    int number = StdRandom.nextInt(0, 10_000);
                    dataFunnel.setActivityId(activityId);
                    dataFunnel.setVisitCount(number);
                    dataFunnel.setPrizeNumber(number);
                    dataFunnel.setRecipientNumber(number);
                    dataFunnel.setYmdPrizeNumber(number);
                    dataFunnel.setYmdParticipantNumber(number);
                    return dataFunnel;
                }).limit(capacity)
                .collect(Collectors.toList());
    }

    private List<EquityDto> mockEquity(List<String> activityIdList) {
        return null;
    }
}
