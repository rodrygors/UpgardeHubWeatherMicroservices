package com.botcamp.serverside.service;

import com.botcamp.serverside.model.Weather;
import com.botcamp.serverside.provider.WeatherProvider;
import com.botcamp.serverside.repository.WeatherRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
            LocalDateTime timeThreshold = weather.getDateTime().plusHours(1);

            LocalDateTime date = LocalDateTime.now();

            System.out.println(date + " ||||| " + timeThreshold);
            if (date.isBefore(timeThreshold)) {
                System.out.println("Hello");
                return weather;
            }
            else{
                Weather newWeather = weatherProvider.getWeatherForCity(city);

                weather.setDateTime(newWeather.getDateTime());
                weather.setPrecipitation(newWeather.getPrecipitation());
                weather.setTemperature(newWeather.getTemperature());

                weatherRepository.save(weather);
                return newWeather;
            }
        }
        Weather newWeather = weatherProvider.getWeatherForCity(city);

        weatherRepository.save(newWeather);
        return newWeather;
    }
}

