package com.botcamp.serverside.controller;

import com.botcamp.serverside.controller.response.WeatherResponse;
import com.botcamp.serverside.model.Weather;
import com.botcamp.serverside.service.WeatherService;
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
    public Weather getWeatherByCity(@RequestParam String city) {
        return weatherService.getWeather(city);
    }
//    @GetMapping("/weather/{city}")
//    public WeatherResponse getWeatherByCity(@PathVariable(value = "city") String city){
//            return weatherService.getWeather(city).createWeatherResponse();
//    }
}