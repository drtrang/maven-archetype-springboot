package ${package};

import ${package}.service.CityService;
import ${package}.util.JsonUtils;
import com.baidu.unbiz.easymapper.mapping.ServiceLoaderHelper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot 启动类
 *
 * @author trang
 */
@SpringBootApplication
@MapperScan("${package}.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableCaching(proxyTargetClass = true)
@Slf4j
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        // 设置 dubbo 使用 slf4j 记录日志
        // dubbo使用日志顺序 log4j->slf4j->common logging->jdk log
        System.setProperty("dubbo.application.logger", "slf4j");
        // 设置 druid 使用 slf4j 记录日志
        System.setProperty("druid.logType", "slf4j");
        // TODO 初始化 EasyMapper，临时解决 SPI 多线程问题
        ServiceLoaderHelper.getInstance();
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private CityService cityService;

    @Override
    public void run(String... args) throws Exception {
        log.info("application is running...");
        log.info(JsonUtils.toJson(cityService.selectByPk(1)));
    }

    @RestController
    public static class WelcomeController {

        @GetMapping("/")
        public ResponseEntity<String> welcome() {
            return ResponseEntity.ok("Welcome!");
        }

    }

}