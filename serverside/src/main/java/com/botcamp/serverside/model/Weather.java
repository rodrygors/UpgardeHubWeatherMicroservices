package com.botcamp.serverside.model;

import com.botcamp.serverside.controller.response.WeatherResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Weather {
    @Id
    private String id;
    private float temperature;
    private LocalDateTime dateTime;
    private float precipitation;
    private String city;

    @JsonIgnore
    public WeatherResponse createWeatherResponse(){
        return new WeatherResponse(
                this.temperature,
                this.dateTime,
                this.precipitation,
                this.city
        );
    }
}
