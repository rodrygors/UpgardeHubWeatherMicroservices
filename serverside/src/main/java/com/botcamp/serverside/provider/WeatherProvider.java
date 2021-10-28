package com.botcamp.serverside.provider;

import com.botcamp.serverside.controller.response.WeatherResponseApi;
import com.botcamp.serverside.model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherProvider {
    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiKey;

    public WeatherProvider(RestTemplate restTemplate, @Value("${weather.api.url}") String apiUrl, @Value("${weather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
    }

    public Weather getWeatherForCity(String city) {
        String url = apiUrl + "?key=" + apiKey + "&q=" + city + "&aqi=no";
        final ResponseEntity<WeatherResponseApi> response = restTemplate.getForEntity(url, WeatherResponseApi.class);
        return Weather
                .builder()
                .temperature(response.getBody().getCurrent().getTempC())
                .dateTime(response.getBody().getCurrent().getLastUpdated())
                .precipitation(response.getBody().getCurrent().getPrecipMm())
                .build();
    }
}

