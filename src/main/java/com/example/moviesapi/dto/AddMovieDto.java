package com.example.moviesapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class AddMovieDto {
    private String title;
    private String description;
    private Double rating;
    private LocalDate releaseDate;
}
