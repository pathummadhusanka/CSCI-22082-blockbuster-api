package com.example.blockbusterapiv3.service;

import com.example.blockbusterapiv3.model.Movie;
import com.example.blockbusterapiv3.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Iterable<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    // TODO : get a single movie by ID
    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Iterable<Movie> addMovies(List<Movie> movies){
        return movieRepository.saveAll(movies);
    }

    public Movie getMovieByTitle(String title){
        return movieRepository.findMovieByTitle(title);
    }

    public boolean deleteMovieById(Long id){
        if(movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Optional<Movie> updateMovieById(Long id, Movie movieDetails){
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(movieDetails.getTitle());
                    movie.setGenre(movieDetails.getGenre());
                    movie.setAvailable(movieDetails.isAvailable());
                    movie.setReleaseYear(movieDetails.getReleaseYear());
                    return movieRepository.save(movie);
                });
    }

    public Optional<Movie> rentMovieById(Long id){
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setAvailable(false);
                    return movieRepository.save(movie);
                });
    }

    public Optional<Movie> returnMovieById(Long id){
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setAvailable(true);
                    return movieRepository.save(movie);
                });
    }

}
