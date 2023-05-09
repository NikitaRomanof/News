package com.news.news;

import com.news.news.repository.NewsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllersTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private NewsRepository repository;

    @Test
    public void get_all_news() throws Exception {
        mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void get_add_page() throws Exception {
        mockMvc.perform(get("/addNews").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void get_del_page() throws Exception {
        mockMvc.perform(get("/delNews").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenNews_whenAdd_thenRedirect() throws Exception {
        mockMvc.perform(
                        post("/addNews")
                                .param("title", "First news")
                                .param("date", LocalDate.now().toString())
                                .param("text", "Body news"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void givenNews_whenDel_thenRedirect() throws Exception {
        mockMvc.perform(
                        get("/deleteNews/1")
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is3xxRedirection());

    }

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }
}
