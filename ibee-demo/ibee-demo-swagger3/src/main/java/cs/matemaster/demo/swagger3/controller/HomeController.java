package cs.matemaster.demo.swagger3.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Api(value = "HomeController", tags = "系统界面控制器")
@RestController
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {

    @ApiOperation("访问主界面")
    @GetMapping("get")
    public void home() {
        System.out.println("Hello Web!");
    }
}
