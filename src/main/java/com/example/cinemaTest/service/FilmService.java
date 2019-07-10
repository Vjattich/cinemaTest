package com.example.cinemaTest.service;

import com.example.cinemaTest.model.Film;
import com.example.cinemaTest.model.filters.FilmFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {

    Film getFilm(int id);

    List<Film> getFilms(FilmFilter filter);

}
