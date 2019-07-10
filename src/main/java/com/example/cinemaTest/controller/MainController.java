package com.example.cinemaTest.controller;

import com.example.cinemaTest.exception.NoPlaceException;
import com.example.cinemaTest.model.Film;
import com.example.cinemaTest.model.Ticket;
import com.example.cinemaTest.model.dto.FilmDto;
import com.example.cinemaTest.model.filters.FilmFilter;
import com.example.cinemaTest.model.filters.TicketFilter;
import com.example.cinemaTest.service.FilmService;
import com.example.cinemaTest.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private final FilmService filmService;
    private final TicketService ticketService;


    @GetMapping("/getFilms")
    public List<FilmDto> getFilms(@ModelAttribute FilmFilter filter) {

        List<FilmDto> dtos = new ArrayList<>();

        List<Film> films = filmService.getFilms(filter);

        for (Film film : films) {
            dtos.add(new FilmDto(film));
        }

        return dtos;
    }

    @GetMapping("/getFilm/{id}")
    public FilmDto getFilm(@PathVariable("id") int id) {
        return new FilmDto(filmService.getFilm(id));
    }

    @PostMapping("/buyTicket")
    public Ticket buyTicket(@RequestBody Ticket ticket) throws NoPlaceException {
        return ticketService.save(ticket);
    }

    @GetMapping("/viewTicket/{id}")
    public Ticket viewTicket(@PathVariable("id") int id) {
        return ticketService.getTicket(id);
    }

    @GetMapping("/viewTickets")
    public List<Ticket> viewTicket(@ModelAttribute TicketFilter filter) {
        return ticketService.getTickets(filter);
    }

}
