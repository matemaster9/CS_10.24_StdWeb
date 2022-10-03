package cs.matemaster.demo.dbcp.service.impl;

import cs.matemaster.demo.dbcp.domain.SystemUserDto;
import cs.matemaster.demo.dbcp.mapper.SysUserMapper;
import cs.matemaster.demo.dbcp.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author matemaster
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private SysUserMapper sysUserMapper;

    @Override
    public Boolean logoutUser(SystemUserDto systemUser) {

        return null;
    }

    @Override
    public String register(SystemUserDto systemUser) {

        return null;
    }

    @Override
    public Boolean update(SystemUserDto systemUser) {
        return null;
    }
}
