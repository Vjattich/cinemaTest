package com.example.cinemaTest.model.dto;

import com.example.cinemaTest.enums.Genre;
import com.example.cinemaTest.model.Film;
import com.example.cinemaTest.model.Session;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FilmDto {

    public FilmDto(Film film) {
        this.id = film.getId();
        this.name = film.getName();
        this.popularity = film.getPopularity();
        this.genre = film.getGenre();
        this.description = film.getDescription();

        List<SessionDto> dtos = new ArrayList<>();

        for (Session session : film.getSessions()) {
            dtos.add(new SessionDto(session));
        }

        this.sessions = dtos;
    }

    private int id;

    private String name;

    private int popularity;

    private Genre genre;

    private String description;

    private List<SessionDto> sessions;

}
