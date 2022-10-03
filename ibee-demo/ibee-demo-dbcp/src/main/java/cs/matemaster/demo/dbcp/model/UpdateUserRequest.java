package cs.matemaster.demo.dbcp.model;

import lombok.Data;

/**
 * @author matemaster
 */
@Data
public class UpdateUserRequest {

    private String phoneNumber;

    private String password;

    public void check() {
    }
}
