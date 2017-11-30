package ${package}.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置，默认不开启，可使用 'spring.profiles.configure.includes' 导入
 *
 * @author trang
 */
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("${artifactId}")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("${package}.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("基于 Swagger2 的自动化文档")
                .contact(new Contact("Trang", "https://github.com/drtrang", "donghao.l@hotmail.com"))
                .version("1.0")
                .build();
    }

}