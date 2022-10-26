package cs.matemaster.demo.jedis.domain;

import lombok.Data;
import lombok.Setter;

/**
 * @author matemaster
 */
@Setter
@Data
public class SystemUserDto {

    private final String code;

    private final String passwd;

    private Integer permission;
}
