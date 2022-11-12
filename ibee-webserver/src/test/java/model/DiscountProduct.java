package model;

import constant.DiscountCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.DiscountService;

/**
 * @author matemaster
 */
@Data
@NoArgsConstructor
public class DiscountProduct {
    private ScenicArea product;
    private DiscountCodeEnum discountCode;

    public DiscountProduct(ScenicArea scenicArea) {
        DiscountProduct discountProduct = new DiscountProduct();
        discountProduct.setProduct(scenicArea);
        discountProduct.setDiscountCode(DiscountService.getDiscountCode());
    }
}
