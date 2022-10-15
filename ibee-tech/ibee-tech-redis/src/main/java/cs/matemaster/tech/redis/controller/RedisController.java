package cs.matemaster.tech.redis.controller;

import cs.matemaster.tech.redis.model.AddUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@Tag(name = "RedisController", description = "Redis控制器")
@RestController
@RequestMapping("/api")
public class RedisController {

    @Operation(summary = "添加用户")
    @PostMapping("addUser")
    public Boolean addUser(@RequestBody AddUserRequest request) {
        return true;
    }
}
