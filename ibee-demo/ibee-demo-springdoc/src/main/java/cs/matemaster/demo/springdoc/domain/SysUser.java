package cs.matemaster.demo.springdoc.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@Schema(name = "系统用户")
public class SysUser {
    @Schema(name = "username")
    private String username;

    @Schema(name = "password")
    private String password;
}
