package cs.matemaster.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author matemaster
 */
@Data
public class ActivityDataFunnel {

    @Schema(name = "日期")
    private LocalDate date;

    @Schema(name = "活动ID")
    private String activityId;

    @Schema(name = "部门id")
    private String deptId;

    @Schema(name = "访问人次")
    private Integer visitCount;

    @Schema(name = "参与人次")
    private Integer participantNumber;

    @Schema(name = "中奖人次")
    private Integer prizeNumber;

    @Schema(name = "领奖人次")
    private Integer recipientNumber;

    @Schema(name = "羊毛党参与人次")
    private Integer ymdParticipantNumber;

    @Schema(name = "羊毛党领奖人次")
    private Integer ymdPrizeNumber;


    public static ActivityDataFunnel getInstance(String activityId, ActivityBaseInfoDto activityBaseInfo, DataFunnelDto dataFunnel) {
        ActivityDataFunnel activityDataFunnel = new ActivityDataFunnel();
        activityDataFunnel.setDate(dataFunnel.getDate());
        activityDataFunnel.setActivityId(activityId);
        activityDataFunnel.setDeptId(activityBaseInfo.getDeptId());
        activityDataFunnel.setVisitCount(dataFunnel.getVisitCount());
        activityDataFunnel.setParticipantNumber(dataFunnel.getParticipantNumber());
        activityDataFunnel.setPrizeNumber(dataFunnel.getPrizeNumber());
        activityDataFunnel.setRecipientNumber(dataFunnel.getRecipientNumber());
        activityDataFunnel.setYmdParticipantNumber(dataFunnel.getYmdParticipantNumber());
        activityDataFunnel.setYmdPrizeNumber(dataFunnel.getYmdPrizeNumber());
        return activityDataFunnel;
    }
}
