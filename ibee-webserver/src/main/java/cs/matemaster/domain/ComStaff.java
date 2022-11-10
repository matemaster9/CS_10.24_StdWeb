package cs.matemaster.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@Schema(description = "公司员工业务域对象")
public class ComStaff {

    @Schema(description = "编号")
    private String code;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "学历")
    private String education;
}
