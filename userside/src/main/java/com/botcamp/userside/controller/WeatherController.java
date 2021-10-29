package com.botcamp.userside.controller;

import com.botcamp.userside.Service.WeatherService;
import com.botcamp.userside.controller.response.WeatherResponse;
import com.botcamp.userside.model.Weather;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public WeatherResponse getWeatherForCity(@RequestParam String city){
        return weatherService.findWeatherForCity(city).createWeatherResponse();
    }
}
