package com.botcamp.serverside.repository;

import com.botcamp.serverside.model.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherRepository extends MongoRepository<Weather, String> {
    Optional<Weather> findByCity(String city);
}
