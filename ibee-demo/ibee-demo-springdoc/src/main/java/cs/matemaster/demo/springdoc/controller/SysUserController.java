package cs.matemaster.demo.springdoc.controller;

import cs.matemaster.demo.springdoc.domain.SysUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Tag(name = "SysUserController", description = "系统用户控制器")
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Operation(summary = "注册")
    @PostMapping("register")
    public Boolean register(@RequestBody SysUser user) {
        return true;
    }

    @Operation(summary = "查询")
    @PostMapping("getSysUser")
    public SysUser getSysUser() {
        return new SysUser();
    }
}
