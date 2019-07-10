package com.example.cinemaTest.model.dto;

import com.example.cinemaTest.enums.City;
import com.example.cinemaTest.model.Session;
import lombok.Data;

import java.util.Date;

@Data
public class SessionDto {

    public SessionDto(Session session) {
        this.city = session.getCity();
        this.date = session.getDate();
    }

    private City city;

    private Date date;
}
