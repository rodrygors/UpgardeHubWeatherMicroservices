package com.botcamp.userside.provider;

import com.botcamp.userside.controller.response.WeatherResponse;
import com.botcamp.userside.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherProvider<url> {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public WeatherProvider(RestTemplate restTemplate, @Value("${serverside.api.url}") String url) {
        this.restTemplate = restTemplate;
        this.baseUrl = url;
    }

    public Weather getWeatherForCity(String city){
        String url = baseUrl + "weather/&q=" + city;
        final ResponseEntity<Weather> response = restTemplate.getForEntity(url, Weather.class);
        return new Weather(
                response.getBody().getId(),
                response.getBody().getTemperature(),
                response.getBody().getDateTime(),
                response.getBody().getTemperature(),
                response.getBody().getCity()
        );
    }
}
