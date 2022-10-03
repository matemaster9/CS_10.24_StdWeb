package cs.matemaster.demo.springdoc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Tag(name = "OpenApiController", description = "OpenAPI3测试控制器")
@RestController
@RequestMapping("/api")
public class OpenApiController {

    @Operation(summary = "欢迎界面")
    @GetMapping("welcome")
    public void welcome() {
        System.out.println("welcome");
    }
}
