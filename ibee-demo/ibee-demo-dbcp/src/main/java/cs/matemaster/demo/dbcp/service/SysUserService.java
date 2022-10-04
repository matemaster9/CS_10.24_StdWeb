package cs.matemaster.demo.dbcp.service;

import cs.matemaster.demo.dbcp.domain.SystemUserDto;

/**
 * @author matemaster
 */
public interface SysUserService {
    Boolean logoutUser(SystemUserDto systemUser);

    void register(SystemUserDto systemUser);

    Boolean update(SystemUserDto systemUser);
}
