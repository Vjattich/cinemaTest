package com.example.cinemaTest.dao;

import com.example.cinemaTest.model.Film;
import com.example.cinemaTest.model.filters.FilmFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query(
            "select f from Film f where " +
                    "(:#{#filter.genre} IS NULL OR f.genre = :#{#filter.genre})" +
                    "AND (:#{#filter.name} IS NULL OR f.name = :#{#filter.name}) " +
                    "AND (:#{#filter.popularity} IS NULL OR f.popularity > :#{#filter.popularity})" +
                    "ORDER BY f.name"
    )
    List<Film> getAllByFilter(@Param("filter") FilmFilter filter);
}
