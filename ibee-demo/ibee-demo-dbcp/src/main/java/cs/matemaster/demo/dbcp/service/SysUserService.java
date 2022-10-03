package cs.matemaster.demo.dbcp.service;

import cs.matemaster.demo.dbcp.domain.SystemUserDto;

/**
 * @author matemaster
 */
public interface SysUserService {
    Boolean logoutUser(SystemUserDto systemUser);

    String register(SystemUserDto systemUser);

    Boolean update(SystemUserDto systemUser);
}
