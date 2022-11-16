package cs.matemaster.controller;

import cs.matemaster.model.dto.PaymentAccount;
import cs.matemaster.service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author matemaster
 */
@Tag(name = "PaymentController", description = "支付控制器")
@RestController
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;
}
