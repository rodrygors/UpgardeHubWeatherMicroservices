package com.botcamp.serverside.service;

import com.botcamp.serverside.model.Weather;
import com.botcamp.serverside.provider.WeatherProvider;
import com.botcamp.serverside.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final WeatherProvider weatherProvider;

    public WeatherService(WeatherRepository weatherRepository, WeatherProvider weatherProvider) {
        this.weatherRepository = weatherRepository;
        this.weatherProvider = weatherProvider;
    }

    public Weather getWeather(String city) {
        Optional<Weather> weatherOptional = weatherRepository.findByCity(city);
        if (weatherOptional.isPresent()) {
            Weather weather = weatherOptional.get();

            LocalDateTime timeThreshold = weather.getDateTime().minusHours(1);
            if (weather.getDateTime().isAfter(timeThreshold)) {
                return weather;
            }
        }

        Weather newWeather = weatherProvider.getWeatherForCity(city);
        weatherRepository.save(newWeather);
        return newWeather;

    }
}

