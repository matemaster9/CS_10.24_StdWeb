package cs.matemaster.demo.dbcp.facade.impl;

import cs.matemaster.demo.dbcp.domain.SystemUserDto;
import cs.matemaster.demo.dbcp.facade.SysUserFacade;
import cs.matemaster.demo.dbcp.model.LogoutRequest;
import cs.matemaster.demo.dbcp.model.RegisterRequest;
import cs.matemaster.demo.dbcp.model.UpdateUserRequest;
import cs.matemaster.demo.dbcp.service.SysUserService;
import cs.matemaster.demo.dbcp.util.BusinessUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
@AllArgsConstructor
public class SysUserFacadeImpl implements SysUserFacade {

    private SysUserService sysUserService;

    @Override
    public Boolean logoutUser(LogoutRequest request) {
        request.check();

        SystemUserDto systemUser = new SystemUserDto();
        systemUser.setUsername(request.getUsername());
        systemUser.setPassword(request.getPassword());
        systemUser.setRegisterPhone(request.getPhoneNumber());

        return sysUserService.logoutUser(systemUser);
    }

    @Override
    public String register(RegisterRequest request) {
        request.check();

        String username = BusinessUtil.generateUniqueCode("SYS");

        SystemUserDto systemUser = new SystemUserDto();
        systemUser.setUsername(username);
        systemUser.setPassword(request.getPassword());
        systemUser.setRegisterPhone(request.getPhoneNumber());

        sysUserService.register(systemUser);

        return username;
    }

    @Override
    public Boolean update(UpdateUserRequest request) {
        request.check();

        SystemUserDto systemUser = new SystemUserDto();
        systemUser.setUsername(request.getUsername());
        systemUser.setPassword(request.getPassword());
        systemUser.setRegisterPhone(request.getPhoneNumber());

        return sysUserService.update(systemUser);
    }
}
