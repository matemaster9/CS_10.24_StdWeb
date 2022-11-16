package cs.matemaster.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@Schema(title = "活动基础信息DTO")
public class ActivityBaseInfoDto {

    @Schema(name = "活动id")
    private String activityId;

    @Schema(name = "活动名称")
    private String activityName;

    @Schema(name = "活动类型")
    private Integer activityType;

    @Schema(name = "部门ID")
    private String deptId;
}
