package com.example.cinemaTest.service.impl;

import com.example.cinemaTest.dao.FilmRepository;
import com.example.cinemaTest.model.Film;
import com.example.cinemaTest.model.filters.FilmFilter;
import com.example.cinemaTest.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    //todo описать зачем
    public Film getFilm(int id) {
        return filmRepository.getOne(id);
    }

    @Override
    public List<Film> getFilms(FilmFilter filter) {
        return filmRepository.getAllByFilter(filter);
    }

}
