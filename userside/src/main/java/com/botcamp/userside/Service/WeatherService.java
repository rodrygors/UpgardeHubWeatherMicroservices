package com.botcamp.userside.Service;

import com.botcamp.userside.model.Weather;
import com.botcamp.userside.provider.WeatherProvider;
import com.botcamp.userside.repository.RequestLogRepository;
import org.springframework.stereotype.Service;



@Service
public class WeatherService {
    private final WeatherProvider weatherProvider;
    private final RequestLogRepository requestLogRepository;
    private final String user = "João";
    private final String userId = "askudb34332kdasdn";

    public WeatherService(WeatherProvider weatherProvider, RequestLogRepository requestLogRepository) {
        this.weatherProvider = weatherProvider;
        this.requestLogRepository = requestLogRepository;
    }

    public Weather findWeatherForCity(String city) {
        return weatherProvider.getWeatherForCity(city);
    }
}
