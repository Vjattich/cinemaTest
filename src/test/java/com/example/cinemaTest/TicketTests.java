package com.example.cinemaTest;

import com.example.cinemaTest.dao.TicketRepository;
import com.example.cinemaTest.model.Ticket;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.util.NestedServletException;

import java.util.Date;

import static com.example.cinemaTest.TestUtils.fromJson;
import static com.example.cinemaTest.TestUtils.toJson;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TicketTests extends WebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketRepository ticketRepository;

    private Ticket ticketOne, ticketTwo;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void init() {

        ticketOne = new Ticket();
        ticketOne.setPlace(1);
        ticketOne.setOwnerEmail("@mail.ru");
        ticketOne.setOwnerPhoneNumber("+7123123123");

        ticketTwo = new Ticket();
        ticketTwo.setId(1);
        ticketTwo.setPlace(1);
        ticketTwo.setCreationDate(new Date());
        ticketTwo.setOwnerEmail("@mail.ru");
        ticketTwo.setOwnerPhoneNumber("+7123123123");

        when(ticketRepository.save(ticketOne)).thenReturn(ticketTwo);

        when(ticketRepository.getOne(1)).thenReturn(ticketTwo);

    }

    @Test
    public void buyTicket() throws Exception {

        MvcResult mvcResult = mockMvc
                .perform(
                        post("/buyTicket")
                                .contentType(APPLICATION_JSON_UTF8)
                                .content(toJson(ticketOne))
                )
                .andExpect(status().isOk())
                .andReturn();

        Ticket response = (Ticket) fromJson(mvcResult.getResponse().getContentAsString(), Ticket.class);

        assertEquals(response, ticketTwo);

    }

    @Test
    public void buyTicketWithNoPlace() throws Exception {

        when(ticketRepository.findLastPlaceForSession(any())).thenReturn(1);

        exception.expect(NestedServletException.class);
        mockMvc
                .perform(
                        post("/buyTicket")
                                .contentType(APPLICATION_JSON_UTF8)
                                .content(toJson(ticketOne))
                )
                .andExpect(status().isOk());

    }

    @Test
    public void viewTicket() throws Exception {

        mockMvc
                .perform(get("/viewTicket/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));

    }


}
