package com.example.blockbusterapiv3.controller;

import com.example.blockbusterapiv3.model.Movie;
import com.example.blockbusterapiv3.model.MovieGenre;
import com.example.blockbusterapiv3.repository.MovieRepository;
import com.example.blockbusterapiv3.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

//    private Map<Long, Movie> movies = new HashMap<>();
//    private final AtomicLong idCounter = new AtomicLong();
//
//    public MovieController() {
//        Movie m1 = new Movie("300", 2007, true, MovieGenre.WAR);
//        m1.setId(idCounter.incrementAndGet());
//        movies.put(m1.getId(), m1);
//    }

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
       this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Movie>>getMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }
//    public ResponseEntity<Map<Long,Movie>> getMovies() {
//        return ResponseEntity.ok(movies);
//    }


    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id) {
        Optional<Movie> m = movieService.getMovieById(id);
        if(m.isPresent()){
            return ResponseEntity.ok(m.get());
        }
        return ResponseEntity.notFound().build();
    }
//    public ResponseEntity<Movie> getMovieById(@PathVariable long id) {
//        Movie m = movies.get(id);
//        return m == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(m);
//    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }
//    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
//        //
//        //
//        return ResponseEntity.ok(movie);
//    }



//    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
//        movie.setId(idCounter.incrementAndGet());
//        movies.put(movie.getId(), movie);
//        return ResponseEntity.ok(movie);
//    }

    @DeleteMapping("/{id}")
    public boolean deleteMovie(@PathVariable long id){
        return movieService.deleteMovieById(id);
    }
//    public ResponseEntity<Movie> deleteMovie(@PathVariable long id) {
//        Movie m = movies.get(id);
//        if (m == null) {
//            return ResponseEntity.notFound().build();
//        }
//        movies.remove(id);
//        return ResponseEntity.ok(m);
//    }

    @PutMapping("/{id}")
    public Optional<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movie){
        return movieService.updateMovieById(id, movie);
    }
//    public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movie) {
//        Movie m = movies.get(id);
//        if(m == null) {
//            return ResponseEntity.notFound().build();
//        }
//        movie.setId(id);
//        movies.put(id, movie);
//        return ResponseEntity.ok(m);
//    }

    @GetMapping("rent/{id}")
    public Optional<Movie> rentMovie(@PathVariable Long id){
        return movieService.rentMovieById(id);
    }
//    public ResponseEntity<?> rentMovie(@PathVariable Long id){
//        Movie movie = movies.get(id);
//        if(movie != null && movie.isAvailable()){
//            movie.setAvailable(false);
//            return ResponseEntity.ok(movie);
//        }
//        return ResponseEntity.notFound().build();
//    }

    @GetMapping("return/{id}")
    public Optional<Movie> returnMovie(@PathVariable Long id){
        return movieService.returnMovieById(id);
    }
//    public ResponseEntity<?> returnMovie(@PathVariable Long id){
//        Movie movie = movies.get(id);
//        if(movie !=null && !movie.isAvailable()){
//            movie.setAvailable(true);
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }



}
