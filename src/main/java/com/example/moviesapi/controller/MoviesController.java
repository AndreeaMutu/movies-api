package com.example.moviesapi.controller;

import com.example.moviesapi.dto.AddMovieDto;
import com.example.moviesapi.entity.Movie;
import com.example.moviesapi.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MoviesController {
    private final MoviesRepository repository;

    @GetMapping("/movies")
    public List<Movie> allMovies() {
        return repository.findAll();
    }

    @PostMapping("movie")
    public Movie addMovie(@RequestBody AddMovieDto addMovieDto) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(addMovieDto, movie);
        return repository.save(movie);
    }
}
