package cs.matemaster.demo.jackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysUserDto {

    private String username;

    private String password;
}
