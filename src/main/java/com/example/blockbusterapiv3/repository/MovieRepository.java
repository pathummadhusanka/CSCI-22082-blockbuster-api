package com.example.blockbusterapiv3.repository;

import com.example.blockbusterapiv3.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    //Find all movies that are available
    List<Movie> findMoviesByAvailable(boolean available);

    List<Movie> findMoviesByReleaseYearBetween(int releaseYear, int releaseYear2);

    Movie findMovieByTitle(String title);
}
