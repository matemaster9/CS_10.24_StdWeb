package cs.matemaster.tech.redis.model;

import cs.matemaster.tech.redis.domain.SystemUserDto;
import lombok.Data;

/**
 * @author matemaster
 */
@Data
public class AddUserRequest {

    private Boolean cacheFlag;

    private SystemUserDto systemUser;
}
