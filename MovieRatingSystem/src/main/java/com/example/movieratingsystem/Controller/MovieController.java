package com.example.movieratingsystem.Controller;

import com.example.movieratingsystem.Model.Movie;
import com.example.movieratingsystem.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private  final MovieService movieService;

    //get
    @GetMapping("/get")
    public ResponseEntity getMovie(){

        List<Movie> movies=movieService.getMovies();
        return ResponseEntity.status(200).body(movies);
    }

    //add

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Congrats!, your Movie has been successfully added");
    }

    @PostMapping("/add-check")
    public ResponseEntity addtheMovie(@Valid @RequestBody Movie movie,Integer DirectorID){
        movieService.addtheMovie(movie,DirectorID);
        return ResponseEntity.status(200).body("Congrats!, your Movie has been successfully added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@Valid @RequestBody Movie movie,@PathVariable Integer id){
        movieService.updateMovie(movie,id);
        return ResponseEntity.status(200).body("your Movie has been successfully updated!");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Sadly, yor Movie has been deleted");
    }

    //get by category
    @GetMapping("/get-category/{category}")
    public ResponseEntity getCategory(@PathVariable String category){
        List<Movie>movies=movieService.getCategory(category);
        return ResponseEntity.status(200).body(movies);
    }

    //Get By Rating
    @GetMapping("/get-rating/{rating}")
    public ResponseEntity getByRating(@PathVariable Integer rating){
        List<Movie>movies=movieService.getByRate(rating);
        return ResponseEntity.status(200).body(movies);
    }

    //get by name
    @GetMapping("/get-name/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        Movie movie=movieService.getByName(name);
        return ResponseEntity.status(200).body(movie);
    }


    //get duration
    @GetMapping("/get-duration/{name}")
    public ResponseEntity getDuration(@PathVariable String name){
        Integer movie =movieService.getDuration(name);
        return ResponseEntity.status(200).body(movie);
    }

    //Create endpoint that takes movie name and return the rate of the movie
    @GetMapping("/get-movie-rate/{name}")
    public ResponseEntity getRateOfMovie(@PathVariable String name){
        Integer movie=movieService.getRateOfMovie(name);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/get-list/{name}")
    //Create endpoint to list movies to a specific director
    public ResponseEntity listMoviesByDName(@PathVariable String name){

        List<Movie> movies=movieService.listMoviesByDName(name);
       return ResponseEntity.status(200).body(movies) ;
    }

    @GetMapping("/get-dname/{name}")
    //Create endpoint that takes movie name and return the director name
    public ResponseEntity RetDirectorName(@PathVariable String name){
        String movie=movieService.RetDirectorName(name);
        return ResponseEntity.status(200).body(movie);
    }
}
