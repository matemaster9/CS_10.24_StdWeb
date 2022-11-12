package service;

import model.ScenicArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author matemaster
 */
public class ShopService {

    private static final Logger log = LoggerFactory.getLogger(ShopService.class);

    public static int getPrice() {
        delay();
        return ThreadLocalRandom.current().nextInt(1, 10_000);
    }

    public static Future<Integer> getPriceAsync() {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(() -> {
            int result = getPrice();
            future.complete(result);
        }).start();

        return future;
    }

    public static Future<Integer> getPriceAsyncV2() {
        return CompletableFuture.supplyAsync(ShopService::getPrice);
    }

    public static Future<Integer> getPriceThrowError() {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                int result = getPriceAndThrow();
                future.complete(result);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }).start();

        return future;
    }

    private static int getPriceAndThrow() {
        throw new RuntimeException("server not available");
    }

    private static void delay() {
        try {
            TimeUnit.MILLISECONDS.sleep(1200);
        } catch (InterruptedException e) {
            log.error(e.toString());
        }
    }

    public static ScenicArea getScenicArea(String name) {
        ScenicArea scenicArea = new ScenicArea();
        scenicArea.setName(name);
        scenicArea.setPrice(getPrice());
        return scenicArea;
    }
}
