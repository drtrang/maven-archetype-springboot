package ${package};

import ${package}.service.CityService;
import ${package}.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@Slf4j
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        System.setProperty("druid.logType", "slf4j");
        SpringApplication.run(Application.class, args);
        log.info("this project is running...");
    }

    @Autowired
    private CityService cityService;

    @Override
    public void run(String... args) throws Exception {
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