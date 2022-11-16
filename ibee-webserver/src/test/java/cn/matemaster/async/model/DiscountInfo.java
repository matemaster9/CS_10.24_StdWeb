package cn.matemaster.async.model;

import cn.matemaster.async.constant.DiscountCodeEnum;
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
