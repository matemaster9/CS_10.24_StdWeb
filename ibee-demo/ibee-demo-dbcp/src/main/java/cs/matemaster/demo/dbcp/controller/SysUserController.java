package cs.matemaster.demo.dbcp.controller;

import cs.matemaster.demo.dbcp.domain.SystemUserDto;
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

    @ApiOperation("注册用户")
    @PostMapping("register")
    public Boolean register(@RequestBody SystemUserDto user) {
        return true;
    }

    @ApiOperation("更新信息l")
    @PostMapping("update")
    public Boolean update(@RequestBody SystemUserDto user) {
        return true;
    }
}
