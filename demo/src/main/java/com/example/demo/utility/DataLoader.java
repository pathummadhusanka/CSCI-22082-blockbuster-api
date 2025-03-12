package com.example.demo.utility;

import com.example.demo.models.Movie;
import com.example.demo.models.MovieGenre;
import com.example.demo.repository.MovieRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    private final MovieRepository movieRepository;

    public DataLoader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    public void loadData() {
        movieRepository.saveAll(
                List.of(
                        new Movie("Inception", 2009, true, MovieGenre.DRAMA),
                        new Movie("Inception", 2009, true, MovieGenre.DRAMA)
                )

        );
    }
}
