package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.models.MovieGenre;
//import com.example.demo.models.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private Map<Long, Movie> movies = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();
//    private final MovieRepository movieRepository;

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

    /*
    @GetMapping
    public Map<Long, Movie> getMovies() {
        return movies;
    }
    */

    @GetMapping
    public ResponseEntity<Map<Long, Movie>> getMovies() {
        return ResponseEntity.ok(movies);
    }
    // curl -i -X GET http://localhost:8080/api/movies

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id) {
        Movie movie = movies.get(id);

        if (movie != null) {
            return ResponseEntity.ok(movie);
        }
        return ResponseEntity.notFound().build();
    }

    // curl -i -X GET http://localhost:8080/api/movies/1

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movieDetails) {

        movieDetails.setId(idCounter.incrementAndGet());
        movies.put(movieDetails.getId(), movieDetails);
        return ResponseEntity.ok(movieDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable Long id, @RequestBody Movie movieDetails) {
        Movie movie = movies.get(id);
        if(movie == null) {
            return ResponseEntity.notFound().build();
        }

        movieDetails.setId(id);
        movies.put(id, movieDetails);
        return ResponseEntity.ok(movieDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable Long id) {
        movies.remove(id);
    }

    @GetMapping("/rent/{id}")
    public ResponseEntity<Movie> rentMovie(@PathVariable Long id) {
        Movie movie = movies.get(id);

        if(movie != null && movie.isAvailable()) {
            movie.setAvailable(false);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/return/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable Long id) {
        Movie movie = movies.get(id);

        if(movie != null && !movie.isAvailable()) {
            movie.setAvailable(true);
            return ResponseEntity.ok().build();

        }

        return ResponseEntity.notFound().build();
    }
}
