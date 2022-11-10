package cs.matemaster.config.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author matemaster
 */
@Component
@AllArgsConstructor
public class SyncThreadPool {

    private SyncThreadPoolYaml syncThreadPoolYaml;

    @Bean
    public ExecutorService getSyncThreadPool() {
        return new ThreadPoolExecutor(
                syncThreadPoolYaml.getCorePoolSize(),
                syncThreadPoolYaml.getMaximumPoolSize(),
                syncThreadPoolYaml.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadFactoryBuilder().setNameFormat("SyncThread-%s").build(),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
