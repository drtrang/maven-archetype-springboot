package ${package}.controller;

import ${package}.model.domain.City;
import ${package}.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CityController
 *
 * @author trang
 */
@RestController
@RequestMapping(path = "/city", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/get/{id}")
    public ResponseEntity<City> getById(@PathVariable Integer id) {
        City city = cityService.selectByPk(id);
        return ResponseEntity.ok(city);
    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<List<City>> getByIds(@PathVariable List<Integer> ids) {
        List<City> list = cityService.selectByIds(ids);
        return ResponseEntity.ok(list);
    }

}