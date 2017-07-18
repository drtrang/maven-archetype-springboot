package ${package}.service.impl;

import ${package}.model.domain.City;
import ${package}.service.CityService;
import org.springframework.stereotype.Service;

@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl<City, Integer> implements CityService {
}