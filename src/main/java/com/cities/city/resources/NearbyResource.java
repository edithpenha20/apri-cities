package com.cities.city.resources;

import java.util.List;

import com.cities.city.entities.City;
import com.cities.city.service.DistanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nearby")
public class NearbyResource {

    private DistanceService distanceService;

    public NearbyResource(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping
    public List<City> nearby(@RequestParam(name = "city_id") final Long cityId,
                             @RequestParam(name = "radius") final Double radius) {

        return distanceService.nearby(cityId, radius);
    }
}
