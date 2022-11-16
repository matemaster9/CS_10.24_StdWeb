package cs.matemaster.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author matemaster
 */
@Data
@Schema(title = "权益dto")
public class EquityDto {

    @Schema(name = "活动id")
    private String activityId;

    @Schema(name = "中奖金额")
    private BigDecimal prizeAmount;

    @Schema(name = "领奖金额")
    private BigDecimal recipientAmount;

    @Schema(name = "领券人数")
    private Integer recipientTicketNumber;

    @Schema(name = "用券人数")
    private Integer useTicketNumber;
}
