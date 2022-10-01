package cs.matemaster.demo.jackson.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComStaffBriefDto {
    private String name;

    private String code;
}
