package com.example.cinemaTest.dao;

import com.example.cinemaTest.model.Session;
import com.example.cinemaTest.model.Ticket;
import com.example.cinemaTest.model.filters.TicketFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("select max(t.place) from Ticket t where t.session.id = :#{#session.id}")
    Integer findLastPlaceForSession(@Param("session") Session session);

    @Query(
            value = "select t from Ticket t where " +
                    "(:#{#filter.filmName} IS NULL OR t.session.film.name = :#{#filter.filmName})" +
                    "AND (cast(:dateFrom as timestamp) IS NULL OR t.creationDate >= :dateFrom) " +
                    "AND (cast(:dateTo as timestamp) IS NULL OR t.creationDate <= :dateTo)" +
                    "AND (:#{#filter.city} IS NULL OR t.session.city = :#{#filter.city})" +
                    "AND (:#{#filter.genre} IS NULL OR t.session.film.genre = :#{#filter.genre})"
    )
    List<Ticket> findTickets(@Param("filter") TicketFilter filter,
                             @Param("dateFrom") Date dateFrom,
                             @Param("dateTo") Date dateTo);
}
