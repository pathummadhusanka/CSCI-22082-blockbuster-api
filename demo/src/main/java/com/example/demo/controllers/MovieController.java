package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.models.MovieGenre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private Map<Long, Movie> movies = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public MovieController() {



        Movie movie1 = new Movie("Mad Max: Fury Road", 2015, true, MovieGenre.ACTION);
        movie1.setId(idCounter.incrementAndGet());
        movies.put(movie1.getId(), movie1);

        Movie movie2 = new Movie("The Dark Knight", 2008, false, MovieGenre.ACTION);
        movie2.setId(idCounter.incrementAndGet());
        movies.put(movie2.getId(), movie2);

        Movie movie3 = new Movie("Saving Private Ryan", 1998, true, MovieGenre.WAR);
        movie3.setId(idCounter.incrementAndGet());
        movies.put(movie3.getId(), movie3);

        Movie movie4 = new Movie("Apocalypse Now", 1979, false, MovieGenre.WAR);
        movie4.setId(idCounter.incrementAndGet());
        movies.put(movie4.getId(), movie4);

        Movie movie5 = new Movie("Inception", 2010, true, MovieGenre.THRILLER);
        movie5.setId(idCounter.incrementAndGet());
        movies.put(movie5.getId(), movie5);

        Movie movie6 = new Movie("Shutter Island", 2010, true, MovieGenre.THRILLER);
        movie6.setId(idCounter.incrementAndGet());
        movies.put(movie6.getId(), movie6);

        Movie movie7 = new Movie("Die Hard", 1988, false, MovieGenre.ACTION);
        movie7.setId(idCounter.incrementAndGet());
        movies.put(movie7.getId(), movie7);

        Movie movie8 = new Movie("Full Metal Jacket", 1987, false, MovieGenre.WAR);
        movie8.setId(idCounter.incrementAndGet());
        movies.put(movie8.getId(), movie8);

    }
    @GetMapping
    public Map<Long, Movie> getMovies() {
        return movies;
    }
}
