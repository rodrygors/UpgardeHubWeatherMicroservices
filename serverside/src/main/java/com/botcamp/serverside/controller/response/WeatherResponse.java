package com.botcamp.serverside.controller.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
    private float temp;
    private LocalDateTime dateTime;
    private float precipitation;
    private String city;
}
