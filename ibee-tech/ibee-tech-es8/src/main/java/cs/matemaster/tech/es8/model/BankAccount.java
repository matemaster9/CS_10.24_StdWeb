package cs.matemaster.tech.es8.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author matemaster
 */
@Data
public class BankAccount {

    /**
     * 银行账户名
     */
    private String accountId;

    /**
     * 账户金额
     */
    private BigDecimal amount;
}
