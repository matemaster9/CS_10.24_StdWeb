package model;

import constant.DiscountCodeEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author matemaster
 */
@Data
public class DiscountInfo {
    private BigDecimal originalPrice;
    private DiscountCodeEnum discountCode;
    private BigDecimal discountPrice;
}
