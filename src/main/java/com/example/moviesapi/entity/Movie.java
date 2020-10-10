package com.example.moviesapi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Double rating;
    private LocalDate releaseDate;
}
