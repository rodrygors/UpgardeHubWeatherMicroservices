package com.botcamp.serverside.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponseCurrent {
    @JsonProperty(value = "temp_c")
    public float tempC;
    @JsonProperty(value = "last_updated")
    public LocalDateTime lastUpdated;
    @JsonProperty(value = "precip_mm")
    public float precipMm;
}
