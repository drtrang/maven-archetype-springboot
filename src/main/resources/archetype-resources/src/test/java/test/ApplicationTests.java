package ${package}.test;

import com.github.pagehelper.PageInfo;
import ${package}.model.domain.City;
import ${package}.service.CityService;
import ${package}.util.JsonUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationTests extends SpringBaseTest {

    @Autowired
    private CityService cityService;

    @Test
    public void selectPage() {
        cityService.selectPageAndCount(null, 1, 3).getList().stream()
                .map(JsonUtils::toJson)
                .forEach(log::info);
    }

}