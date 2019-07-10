package com.example.cinemaTest.model.filters;

import com.example.cinemaTest.enums.Genre;
import lombok.Data;

@Data
public class FilmFilter {

    private String name;

    private Integer popularity;

    private Genre genre;

}
