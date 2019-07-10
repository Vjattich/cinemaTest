package com.example.cinemaTest.service.impl;

import com.example.cinemaTest.exception.NoPlaceException;
import com.example.cinemaTest.dao.TicketRepository;
import com.example.cinemaTest.model.Session;
import com.example.cinemaTest.model.Ticket;
import com.example.cinemaTest.model.filters.TicketFilter;
import com.example.cinemaTest.properties.Properties;
import com.example.cinemaTest.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final Properties properties;

    @Override
    @Transactional(rollbackFor = NoPlaceException.class)
    public Ticket save(Ticket ticket) throws NoPlaceException {

        Integer last = getLastPlace(ticket.getSession());

        if (last == null) {

            ticket.setPlace(1);

            return ticketRepository.save(ticket);

        } else {

            int next = last + 1;

            if (next > properties.getPlaces()) throw new NoPlaceException();

            ticket.setPlace(next);

            return ticketRepository.save(ticket);

        }

    }

    @Override
    public Ticket getTicket(int id) {
        return ticketRepository.getOne(id);
    }

    @Override
    public List<Ticket> getTickets(TicketFilter filter) {
        return ticketRepository.findTickets(filter, filter.getDateFrom(), filter.getDateTo());
    }

    private Integer getLastPlace(Session session) {
        return ticketRepository.findLastPlaceForSession(session);
    }

}
