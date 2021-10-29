package com.botcamp.serverside.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponseCurrent {
    @JsonProperty(value = "temp_c")
    private float tempC;
    @JsonProperty(value = "last_updated")
    private String lastUpdated;
    @JsonProperty(value = "precip_mm")
    private float precipMm;
}
