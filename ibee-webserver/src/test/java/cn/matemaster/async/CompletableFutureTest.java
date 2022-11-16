package cn.matemaster.async;

import lombok.extern.slf4j.Slf4j;
import cn.matemaster.async.model.DiscountInfo;
import cn.matemaster.async.model.DiscountProduct;
import org.junit.Test;
import cn.matemaster.async.service.DiscountService;
import cn.matemaster.async.service.ShopService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@Slf4j
public class CompletableFutureTest {

    @Test
    public void case1() {
        List<String> scenicList = Arrays.asList(
                "平湖秋月",
                "苏堤春晓",
                "曲院风荷",
                "平湖秋月",
                "断桥残雪",
                "花港观鱼",
                "南屏晚钟",
                "双峰插云",
                "雷峰夕照",
                "三潭印月",
                "柳浪闻莺"
        );

        List<CompletableFuture<DiscountInfo>> collect = scenicList.stream()
                .map(scenicName -> CompletableFuture.supplyAsync(() -> ShopService.getScenicArea(scenicName)))
                .map(scenicAreaCompletableFuture -> scenicAreaCompletableFuture.thenApply(DiscountProduct::new))
                .map(discountProductCompletableFuture -> discountProductCompletableFuture.thenCompose(
                        discountProduct -> CompletableFuture.supplyAsync(() -> DiscountService.applyDiscount(discountProduct))
                )).collect(Collectors.toList());

        List<DiscountInfo> result = collect.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        result.forEach(item -> log.info(item.toString()));
    }

    @Test
    public void case1_v2() {
        List<String> scenicList = Arrays.asList(
                "平湖秋月",
                "苏堤春晓",
                "曲院风荷",
                "平湖秋月",
                "断桥残雪",
                "花港观鱼",
                "南屏晚钟",
                "双峰插云",
                "雷峰夕照",
                "三潭印月",
                "柳浪闻莺"
        );

        List<DiscountInfo> result = scenicList.stream()
                .map(item -> CompletableFuture
                        .supplyAsync(() -> ShopService.getScenicArea(item))
                        .thenApply(DiscountProduct::new)
                        .thenCompose(discountProduct -> CompletableFuture.supplyAsync(() -> DiscountService.applyDiscount(discountProduct)))
                        .join()
                ).collect(Collectors.toList());

        result.forEach(item -> log.info(item.toString()));
    }


    @Test
    public void case1_v3() {

        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> 10)
                .thenApply(number -> Math.addExact(number, 100))
                .thenCompose(val -> CompletableFuture.supplyAsync(() -> val * val));

        log.info(future.join().toString());
    }
}
