package com.example.cinemaTest.properties;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sys")
@Setter
public class Properties {

    private Integer places = 32;


    public Integer getPlaces() {
        System.out.println(places);
        return places;
    }
}
