package cn.matemaster.async.service;

import cn.matemaster.async.constant.DiscountCodeEnum;
import lombok.extern.slf4j.Slf4j;
import cn.matemaster.async.model.DiscountInfo;
import cn.matemaster.async.model.DiscountProduct;
import cn.matemaster.async.model.ScenicArea;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author matemaster
 */
@Slf4j
public class DiscountService {

    public static DiscountInfo applyDiscount(DiscountProduct discountProduct) {
        DiscountCodeEnum discountCode = discountProduct.getDiscountCode();
        ScenicArea scenicArea = discountProduct.getProduct();
        BigDecimal discountProportion = BigDecimal.valueOf((100 - (discountCode.getCode() * 10L)) / 100);
        BigDecimal discountPrice = discountProportion.multiply(BigDecimal.valueOf(scenicArea.getPrice()));
        DiscountInfo discountInfo = new DiscountInfo();
        discountInfo.setOriginalPrice(BigDecimal.valueOf(scenicArea.getPrice()));
        discountInfo.setDiscountCode(discountCode);
        discountInfo.setDiscountPrice(discountPrice);
        delay();
        return discountInfo;
    }

    public static DiscountCodeEnum getDiscountCode() {
        return DiscountCodeEnum.getRandomCode();
    }

    private static void delay() {
        try {
            TimeUnit.MILLISECONDS.sleep(1200);
        } catch (InterruptedException e) {
            log.error(e.toString());
        }
    }
}
