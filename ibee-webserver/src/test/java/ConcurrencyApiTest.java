import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author matemaster
 */
@Slf4j
public class ConcurrencyApiTest {

    @Test
    public void createAsync() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName(), ConcurrencyTest.SyncThreadPool);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> Thread.currentThread().getName());
        log.info(future1.join());
        log.info(future2.join());
    }

    @Test
    public void createAsync_v1() {
        CompletableFuture.runAsync(() -> log.debug(Thread.currentThread().getName()), ConcurrencyTest.SyncThreadPool);
        CompletableFuture.runAsync(() -> log.debug(Thread.currentThread().getName()));
    }

    @Test
    public void createAsync_v2() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            networkLatency();
            return Thread.currentThread().getName();
        });

        String result = future.getNow("main");
        log.info(result);
    }

    @Test
    public void getAsync() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            networkLatency();
            return Thread.currentThread().getName();
        });

        String result = future.getNow("main");
        log.info(result);
    }

    @Test
    public void getAsync_v1() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            networkLatency();
            return Thread.currentThread().getName();
        });

        String result;
        try {
            result = future.get(3000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            throw new RuntimeException(ex);
        }
        log.info(result);
    }

    @Test
    public void getAsync_v2() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            networkLatency();
            return Thread.currentThread().getName();
        });

        String result;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }
        log.info(result);
    }

    @Test
    public void getAsync_v2_1() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            networkLatencyThrowError();
            return Thread.currentThread().getName();
        });

        String result;
        try {
            // future.get() 抛出具体异常
            result = future.get();
        } catch (InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        }
        log.info(result);
    }

    @Test
    public void getAsync_v3() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            networkLatency();
            return Thread.currentThread().getName();
        });

        String result = future.join();
        log.info(result);
    }

    @Test
    public void getAsync_v4() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            networkLatencyThrowError();
            return Thread.currentThread().getName();
        });

        // join抛出：java.util.concurrent.CompletionException
        String result = future.join();
        log.info(result);
    }


    private void networkLatency() {
        try {
            // 0.5s ~ 5s 网络延迟
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(500, 5000));
        } catch (InterruptedException ignored) {

        }
    }

    private void networkLatencyThrowError() {
        try {
            // 0.5s ~ 5s 网络延迟
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(500, 5000));
        } catch (InterruptedException ignored) {

        } finally {
            throw new RuntimeException("checked error");
        }
    }
}
