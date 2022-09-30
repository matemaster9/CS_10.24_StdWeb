package cs.matemaster.web.controller;

import cs.matemaster.web.constant.ScannablePackages;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author matemaster
 */
@Api(value = "HomeController", tags = "A1")
@RestController
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {


    @ApiOperation("访问主界面")
    @GetMapping("get")
    public void home() {
        System.out.println("Hello Web!");
    }

    @ApiOperation("获取可扫描包路径")
    @GetMapping("getScannablePackages")
    public String[] getScannablePackages() {
        List<String> packages = new ArrayList<>();
        packages.add(ScannablePackages.Global);
        packages.add(ScannablePackages.WebApp);
        packages.add(ScannablePackages.Swagger);
        return packages.toArray(new String[0]);
    }
    @ApiOperation("验证统一接口的错误")
    @GetMapping("getErrorExample")
    public String getErrorExample() {
        return ScannablePackages.Global;
    }
}
