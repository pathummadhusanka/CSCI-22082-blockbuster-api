package com.example.demo.repository;

import com.example.demo.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
