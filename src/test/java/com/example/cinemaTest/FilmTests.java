package com.example.cinemaTest;

import com.example.cinemaTest.enums.Genre;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.cinemaTest.TestUtils.toJsonList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FilmTests extends WebTest {

    private static final String
            ACTION = "{\"id\":3,\"name\":\"Action\",\"popularity\":3,\"genre\":\"ACTION\",\"description\":\"Action film\",\"sessions\":[{\"city\":\"MOSCOW\",\"date\":\"2019-08-01T15:30:00.000+0000\"},{\"city\":\"PERM\",\"date\":\"2019-08-01T15:00:00.000+0000\"}]}",
            DRAMA = "{\"id\":2,\"name\":\"Drama\",\"popularity\":2,\"genre\":\"DRAMA\",\"description\":\"Drama film\",\"sessions\":[{\"city\":\"MOSCOW\",\"date\":\"2019-08-01T09:30:00.000+0000\"},{\"city\":\"PERM\",\"date\":\"2019-08-01T09:00:00.000+0000\"}]}",
            HORROR = "{\"id\":1,\"name\":\"Fear\",\"popularity\":1,\"genre\":\"HORROR\",\"description\":\"Horror film\",\"sessions\":[{\"city\":\"MOSCOW\",\"date\":\"2019-08-01T13:30:00.000+0000\"},{\"city\":\"PERM\",\"date\":\"2019-08-01T13:00:00.000+0000\"}]}";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getFilms() throws Exception {

        mockMvc
                .perform(get("/getFilms"))
                .andExpect(status().isOk())
                .andExpect(content().json(toJsonList(ACTION, DRAMA, HORROR)));


        mockMvc
                .perform(
                        get("/getFilms")
                                .param("genre", Genre.HORROR.toString())
                )
                .andExpect(status().isOk())
                .andExpect(content().json(toJsonList(HORROR)));

        mockMvc
                .perform(
                        get("/getFilms")
                                .param("name", "Action")
                )
                .andExpect(status().isOk())
                .andExpect(content().json(toJsonList(ACTION)));

        mockMvc
                .perform(
                        get("/getFilms")
                                .param("popularity", "1")
                )
                .andExpect(status().isOk())
                .andExpect(content().json(toJsonList(ACTION, DRAMA)));

    }

    @Test
    public void getFilm() throws Exception {
        mockMvc
                .perform(get("/getFilm/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(HORROR));

    }

}
