package com.example.blockbusterapiv3.utility;

import com.example.blockbusterapiv3.model.Movie;
import com.example.blockbusterapiv3.model.MovieGenre;
import com.example.blockbusterapiv3.repository.MovieRepository;
import com.example.blockbusterapiv3.service.MovieService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    private final MovieService movieService;
//    private final MovieRepository movieRepository;

    public DataLoader(MovieRepository movieRepository, MovieService movieService) {
        this.movieService = movieService;
    }
//    public DataLoader(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }

    @PostConstruct
    public void loadData(){
        movieService.addMovies(
                List.of(
                        new Movie("Inception" , 2009, true, MovieGenre.DRAMA),
                        new Movie("Goodfellas", 1990, true, MovieGenre.DRAMA),
                        new Movie("Apocalypse Now", 1997, true, MovieGenre.WAR)
                )
        );
    }
}
