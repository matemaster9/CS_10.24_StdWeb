import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author matemaster
 */
public class ConcurrencyTest {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        // runnable
        CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        // callable
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        });
        System.out.println(stringCompletableFuture.get());
    }
}
