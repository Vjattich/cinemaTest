package com.example.cinemaTest;

import com.example.cinemaTest.enums.City;
import com.example.cinemaTest.enums.Genre;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static com.example.cinemaTest.enums.City.*;
import static com.example.cinemaTest.enums.Genre.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TicketFilterTest extends WebTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void viewTickets() throws Exception {

        mockMvc
                .perform(
                        get("/viewTickets")
                                .param("filmName", "Fear")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));

        mockMvc
                .perform(
                        get("/viewTickets")
                                .param("city", PERM.toString())
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        mockMvc
                .perform(
                        get("/viewTickets")
                                .param("genre", DRAMA.toString())
                                .param("city", MOSCOW.toString())
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        mockMvc
                .perform(
                        get("/viewTickets")
                                .param("dateFrom", "2019-08-01 17:32:00")
                                .param("dateTo", "2019-08-01 17:34:00")
                                .param("city", MOSCOW.toString())
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

}
