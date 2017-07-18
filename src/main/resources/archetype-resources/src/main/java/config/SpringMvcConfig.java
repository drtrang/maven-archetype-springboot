package ${package}.config;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Spring MVC 配置
 *
 * @author trang
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter4;

    /**
     * FastJson 消息转换器
     */
    @Bean
    public FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter4() {
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        converter.setSupportedMediaTypes(
                ImmutableList.of(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8));
        converter.setFastJsonConfig(fastJsonConfig());
        return converter;
    }

    private FastJsonConfig fastJsonConfig() {
        FastJsonConfig config = new FastJsonConfig();
        config.setCharset(UTF_8);
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        Feature[] parseFeatures = new Feature[]{
                Feature.DisableCircularReferenceDetect
        };
        config.setFeatures(parseFeatures);
        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                SerializerFeature.WriteNonStringKeyAsString,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.DisableCircularReferenceDetect
        };
        config.setSerializerFeatures(serializerFeatures);
        return config;
    }

    /**
     * 自定义消息转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastJsonHttpMessageConverter4);
    }

    /**
     * 设置路径匹配
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer
                // 设置是否是后缀模式匹配，如 "/user" 是否匹配 "/user.*"，默认 true
                .setUseSuffixPatternMatch(false)
                // 设置是否自动后缀路径模式匹配，如 "/user" 是否匹配 "/user/"，默认 true
                .setUseTrailingSlashMatch(true);
    }

    /**
     * 将对于静态资源的请求转发到 Servlet 容器的默认处理静态资源的 Servlet
     * 因为将 Spring 的拦截模式设置为 "/" 时会对静态资源进行拦截
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

}