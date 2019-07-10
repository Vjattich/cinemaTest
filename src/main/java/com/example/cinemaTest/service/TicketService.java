package com.example.cinemaTest.service;

import com.example.cinemaTest.exception.NoPlaceException;
import com.example.cinemaTest.model.Ticket;
import com.example.cinemaTest.model.filters.TicketFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    Ticket save(Ticket ticket) throws NoPlaceException;

    Ticket getTicket(int id);

    List<Ticket> getTickets(TicketFilter filter);

}
