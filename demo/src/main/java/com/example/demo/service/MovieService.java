package com.example.demo.service;

import com.example.demo.models.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    public final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // TODO: get a single movie by ID
    public Optional<Movie> getMovieById(MovieRepository movieRepository, Long id) {
        return movieRepository.findById(id);
    }
}
