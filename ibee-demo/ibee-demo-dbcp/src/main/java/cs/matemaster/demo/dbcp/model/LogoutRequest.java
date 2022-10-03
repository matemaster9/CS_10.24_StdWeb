package cs.matemaster.demo.dbcp.model;

import lombok.Data;

/**
 * @author matemaster
 */
@Data
public class LogoutRequest {

    private String username;

    private String phoneNumber;

    private String password;

    public void check() {

    }
}
