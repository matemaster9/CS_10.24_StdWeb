package cs.matemaster.controller;

import cs.matemaster.domain.ComStaff;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author matemaster
 */
@RestController
@RequestMapping("/com-staff")
@Tag(name = "ComStaffController", description = "公司员工控制器")
public class ComStaffController {

    @Operation(summary = "注册员工")
    @PostMapping("registry")
    public boolean registry(@RequestBody ComStaff comStaff) {
        return true;
    }
}
