package ${package}.test;

import com.github.pagehelper.PageInfo;
import ${package}.model.domain.City;
import ${package}.service.CityService;
import ${package}.util.JsonUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringBootTemplateApplicationTests extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @Autowired
    private CityService cityService;

    @Test
    public void selectPage() {
        PageInfo<City> pageInfo = cityService.selectPageAndCount(null, 1, 3);
        log.info("--- start ---");
        log.info(JsonUtils.toJson(pageInfo));
        log.info("--- end ---");
    }

}