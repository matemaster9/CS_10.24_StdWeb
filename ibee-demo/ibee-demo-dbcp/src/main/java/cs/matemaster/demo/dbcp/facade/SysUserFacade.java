package cs.matemaster.demo.dbcp.facade;

import cs.matemaster.demo.dbcp.model.LogoutRequest;
import cs.matemaster.demo.dbcp.model.RegisterRequest;
import cs.matemaster.demo.dbcp.model.UpdateUserRequest;

/**
 * @author matemaster
 */
public interface SysUserFacade {


    Boolean logoutUser(LogoutRequest request);

    String register(RegisterRequest request);

    Boolean update(UpdateUserRequest request);
}
