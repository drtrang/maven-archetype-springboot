package ${package}.config;

import ${package}.plugin.SpringContextHolder;
import ${package}.plugin.SqlMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

/**
 * Spring Bean 声明
 *
 * @author trang
 */
@Configuration
@Order(999)
public class SpringBeanConfig {

    @Bean
    public static SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SqlMapper sqlMapper(SqlSession sqlSession) {
        return new SqlMapper(sqlSession);
    }

}