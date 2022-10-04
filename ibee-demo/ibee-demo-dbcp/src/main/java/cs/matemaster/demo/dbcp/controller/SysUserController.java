package cs.matemaster.demo.dbcp.controller;

import cs.matemaster.demo.dbcp.facade.SysUserFacade;
import cs.matemaster.demo.dbcp.model.LogoutRequest;
import cs.matemaster.demo.dbcp.model.RegisterRequest;
import cs.matemaster.demo.dbcp.model.UpdateUserRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Api(value = "SysUserController", tags = "Sys")
@RestController
@RequestMapping("/sys-user")
@AllArgsConstructor
public class SysUserController {

    private SysUserFacade sysUserFacade;

    @ApiOperation("注册用户")
    @PostMapping("register")
    public String register(@RequestBody RegisterRequest request) {
        return sysUserFacade.register(request);
    }

    @ApiOperation("更新信息")
    @PostMapping("update")
    public Boolean update(@RequestBody UpdateUserRequest request) {
        return sysUserFacade.update(request);
    }

    @ApiOperation("注销用户")
    @PostMapping("logoutUser")
    public Boolean logoutUser(@RequestBody LogoutRequest request) {
        return sysUserFacade.logoutUser(request);
    }
}
