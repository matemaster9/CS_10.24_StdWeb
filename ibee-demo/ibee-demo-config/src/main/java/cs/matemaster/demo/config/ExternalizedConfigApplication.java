package cs.matemaster.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @author matemaster
 */
@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "cs.matemaster.demo.config.externalize")
public class ExternalizedConfigApplication {
    public static void main(String[] args) {
        // 标准spring应用启动方式
        // SpringApplication.run(ExternalizedConfigApplication.class, args);

        // 禁用命令行参数
        SpringApplication springApplication = new SpringApplication(ExternalizedConfigApplication.class);
        springApplication.setAddCommandLineProperties(false);
        springApplication.run(args);
    }
}
