package com.botcamp.serverside.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponseApi {
    @JsonProperty(value = "current")
    private WeatherResponseCurrent current;
}
