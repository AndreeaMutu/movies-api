package com.example.moviesapi;

import com.example.moviesapi.dto.AddMovieDto;
import com.example.moviesapi.repository.MoviesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class MoviesApiApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MoviesRepository moviesRepository;

    @Test
    void getMoviesShouldCallMoviesRepository() throws Exception {
        mockMvc.perform(get("/movies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void postMoviesShouldCallMoviesRepository() throws Exception {
        AddMovieDto addMovieDto = new AddMovieDto();
        addMovieDto.setTitle("Movie1");
        addMovieDto.setDescription("Movie1 Description");
        addMovieDto.setRating(6.3);
        addMovieDto.setReleaseDate(LocalDate.of(2020, 3, 13));
        mockMvc.perform(post("/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(addMovieDto)))
                .andExpect(status().isOk());
        assertEquals(1, moviesRepository.findAll().size());
    }
}
