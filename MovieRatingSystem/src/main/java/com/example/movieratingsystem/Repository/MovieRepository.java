package com.example.movieratingsystem.Repository;

import com.example.movieratingsystem.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieByName(String name); //yes

    List<Movie>findMovieByRatingGreaterThanEqual(Integer rating); //yes
    Movie findMovieById(Integer id); //yes
    List<Movie>findMovieByCategory(String category); //yes

    List<Movie> getMoviesByDirectorID(Integer id);








}
