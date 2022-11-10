# CS_10.24_StdWeb

# Springdoc

## 常用注解
@Tag
@Operation
@Schema

bean配置：
@Bean
```java
@Bean
public OpenAPI devDocs() {

    Info info = new Info().title("DevDocs API")
            .description("Spring web application")
            .version("v1.0")
            .license(new License().name("Apache 2.0"));

    ExternalDocumentation externalDocumentation = new ExternalDocumentation()
            .description("StdWeb")
            .url("https://github.com/matemaster9/StdWeb");

    return new OpenAPI()
            .info(info)
            .externalDocs(externalDocumentation);
}
```

自动配置属性