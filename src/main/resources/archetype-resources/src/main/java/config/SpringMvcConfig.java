package ${package}.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring MVC 配置
 *
 * @author trang
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 设置路径匹配
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer
                // 是否开启后缀模式匹配，如 /user 是否匹配 /user.*，默认true
                .setUseSuffixPatternMatch(false)
                // 是否开启后缀路径模式匹配，如 /user 是否匹配 /user/，默认true
                .setUseTrailingSlashMatch(true);
    }

    /**
     * 内容判断视图解析器配置
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                //拓展名支持，即/user.json => application/json
                .favorPathExtension(false)
                //url参数支持，即/user?format=json => application/json
                .favorParameter(true)
                //自定义url参数
                .parameterName("data-format")
                //忽略Http Accept Header的支持
                .ignoreAcceptHeader(true)
                //json => application/json
                .mediaType("json", MediaType.APPLICATION_JSON_UTF8)
                //html => text/html
                .mediaType("html", MediaType.TEXT_HTML);
    }

    /**
     * 将对于静态资源的请求转发到 Servlet 容器的默认处理静态资源的 Servlet
     * 因为将 Spring 的拦截模式设置为 "/" 时会对静态资源进行拦截
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}