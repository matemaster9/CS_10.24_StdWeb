import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import model.ScenicArea;
import org.junit.Test;
import service.ShopService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * @author matemaster
 */
@Slf4j
public class ConcurrencyTest {

    private static final ExecutorService SyncThreadPool = new ThreadPoolExecutor(
            10,
            10,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new ThreadFactoryBuilder().setNameFormat("SyncThread-%s").build(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        // runnable
        CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, SyncThreadPool);

        // callable
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName();
        }, SyncThreadPool);
        System.out.println(stringCompletableFuture.get());
    }

    @Test
    public void test2() {
        long now = System.currentTimeMillis();
        ShopService.getPrice();
        log.debug(String.valueOf(System.currentTimeMillis() - now));
    }

    @Test
    public void test2_v1() throws ExecutionException, InterruptedException {
        long now = System.currentTimeMillis();
        Future<Integer> async = ShopService.getPriceAsync();
        log.debug(String.valueOf(System.currentTimeMillis() - now));
        async.get();
    }

    @Test
    public void test3() {
        long now = System.currentTimeMillis();
        Future<Integer> async = ShopService.getPriceThrowError();
        log.debug(String.valueOf(System.currentTimeMillis() - now));
        try {
            async.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getClass().getSimpleName());
            log.error(e.toString());
        }
    }

    @Test
    public void completableTest1() {
        Future<Integer> asyncV2 = ShopService.getPriceAsyncV2();
        try {
            Integer future = asyncV2.get(1, TimeUnit.SECONDS);
            log.info(future.toString());
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            log.error(e.getClass().getSimpleName());
            log.error(e.getMessage());
        }
    }

    @Test
    public void test4() {
        List<String> scenicList = Arrays.asList(
                "平湖秋月",
                "苏堤春晓",
                "曲院风荷",
                "断桥残雪",
                "花港观鱼",
                "南屏晚钟",
                "双峰插云",
                "雷峰夕照",
                "三潭印月",
                "柳浪闻莺"
        );
        long now = System.currentTimeMillis();
        List<ScenicArea> scenicAreas = scenicList.stream()
                .map(scenic -> {
                    ScenicArea scenicArea = new ScenicArea();
                    scenicArea.setName(scenic);
                    scenicArea.setPrice(ShopService.getPrice());
                    return scenicArea;
                }).collect(Collectors.toList());
        log.debug(String.valueOf(System.currentTimeMillis() - now));
    }

    @Test
    public void test4_v2() {
        List<String> scenicList = Arrays.asList(
                "平湖秋月",
                "苏堤春晓",
                "曲院风荷",
                "断桥残雪",
                "花港观鱼",
                "南屏晚钟",
                "双峰插云",
                "雷峰夕照",
                "三潭印月",
                "柳浪闻莺"
        );
        long now = System.currentTimeMillis();
        List<ScenicArea> scenicAreas = scenicList.parallelStream()
                .map(scenic -> {
                    ScenicArea scenicArea = new ScenicArea();
                    scenicArea.setName(scenic);
                    scenicArea.setPrice(ShopService.getPrice());
                    return scenicArea;
                }).collect(Collectors.toList());
        log.debug(String.valueOf(System.currentTimeMillis() - now));
        scenicAreas.forEach(scenicArea -> log.info(scenicArea.toString()));
    }

    @Test
    public void test4_v3() {
        List<String> scenicList = Arrays.asList(
                "平湖秋月",
                "苏堤春晓",
                "曲院风荷",
                "断桥残雪",
                "花港观鱼",
                "南屏晚钟",
                "双峰插云",
                "雷峰夕照",
                "三潭印月",
                "柳浪闻莺"
        );
        long now = System.currentTimeMillis();
        // 分开使用两个stream，可避免延迟特性 v4
        List<CompletableFuture<ScenicArea>> collect = scenicList.stream()
                .map(scenic ->
                        CompletableFuture.supplyAsync(() -> {
                            ScenicArea scenicArea = new ScenicArea();
                            scenicArea.setName(scenic);
                            scenicArea.setPrice(ShopService.getPrice());
                            return scenicArea;
                        })
                ).collect(Collectors.toList());

        List<ScenicArea> result = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());

        log.debug(String.valueOf(System.currentTimeMillis() - now));
        result.forEach(item -> log.info(item.toString()));
    }

    @Test
    public void test4_v4() {
        List<String> scenicList = Arrays.asList(
                "平湖秋月",
                "苏堤春晓",
                "曲院风荷",
                "断桥残雪",
                "花港观鱼",
                "南屏晚钟",
                "双峰插云",
                "雷峰夕照",
                "三潭印月",
                "柳浪闻莺"
        );
        long now = System.currentTimeMillis();
        // 注意stream的延迟执行特性：每个CompletableFuture会在任务执行完后创建下一个
        List<ScenicArea> result = scenicList.stream()
                .map(scenic ->
                        CompletableFuture.supplyAsync(() -> {
                            ScenicArea scenicArea = new ScenicArea();
                            scenicArea.setName(scenic);
                            scenicArea.setPrice(ShopService.getPrice());
                            return scenicArea;
                        })
                ).map(CompletableFuture::join).collect(Collectors.toList());

        log.debug(String.valueOf(System.currentTimeMillis() - now));
        result.forEach(item -> log.info(item.toString()));
    }

    @Test
    public void test5() {

        // 自定义线程池
        CompletableFuture<Void> runAsync1 = CompletableFuture.runAsync(() -> {
            log.info(Thread.currentThread().getName());
        }, SyncThreadPool);

        // fork/join common-pool
        CompletableFuture<Void> runAsync2 = CompletableFuture.runAsync(() -> {
            log.info(Thread.currentThread().getName());
        });

        // 没有join，可能导致主现场过快，看不见异步结果
        runAsync1.join();
        runAsync2.join();
    }
}
