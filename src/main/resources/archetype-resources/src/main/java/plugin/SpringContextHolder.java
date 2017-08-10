package ${package}.plugin;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * 以静态变量保存 Spring ApplicationContext
 * Spring 容器启动后，取出 ApplicationContext 中的 bean
 *
 * @author trang
 */
public class SpringContextHolder implements ApplicationContextAware {

    // Spring容器上下文环境
    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        return context;
    }

    public static <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }

    public static <T> T getBean(String name, Class<T> type) {
        return context.getBean(name, type);
    }

    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    public static boolean isSingleton(String name) {
        return context.isSingleton(name);
    }

    public static boolean isPrototype(String name) {
        return context.isPrototype(name);
    }

    public static boolean isPrototype(String name, Class<?> type) {
        return context.isTypeMatch(name, type);
    }

    public static Class<?> getType(String name) {
        return context.getType(name);
    }

    public static String[] getAliases(String name) {
        return context.getAliases(name);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        return context.getBeansOfType(type);
    }

    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
        return context.getBeansWithAnnotation(annotationType);
    }

    public static String[] getBeanNamesForType(Class<?> type) {
        return context.getBeanNamesForType(type);
    }

    public static String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType) {
        return context.getBeanNamesForAnnotation(annotationType);
    }

    public static String[] getBeanDefinitionNames() {
        return context.getBeanDefinitionNames();
    }

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (context == null) {
            synchronized (SpringContextHolder.class) {
                if (context == null) {
                    SpringContextHolder.context = applicationContext;
                }
            }
        }
    }

}