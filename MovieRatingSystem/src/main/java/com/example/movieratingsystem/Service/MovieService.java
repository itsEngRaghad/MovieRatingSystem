package com.example.movieratingsystem.Service;

import com.example.movieratingsystem.APIException.APIException;
import com.example.movieratingsystem.Model.Director;
import com.example.movieratingsystem.Model.Movie;
import com.example.movieratingsystem.Repository.DirectorRipository;
import com.example.movieratingsystem.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    //-All CRUD

    //get all
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }


//    //add
    public void addMovie(Movie movie){

        movieRepository.save(movie);
    }

    public void addtheMovie(Movie movie, Integer DirectorID){

        if(directorService.findDirectorByID(movie.getId()).getId()!=DirectorID){
            throw new APIException("please add director first.");
        }
        movieRepository.save(movie);

    }




//    //update

    public void updateMovie(Movie movie, Integer id){
        Movie oldMovie=movieRepository.findMovieById(id);
        if(oldMovie==null){
            throw new APIException("sorry no such Movie to update, try another ID");

        }
        oldMovie.setName(movie.getName());
        oldMovie.setCategory(movie.getCategory());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setRating(movie.getRating());
        movieRepository.save(oldMovie);
    }

    //delete

    public void deleteMovie(Integer id){
        Movie theMovie= movieRepository.findMovieById(id);
        if (theMovie==null){
            throw new APIException("this Movie isn't exist, try another id");
        }

        movieRepository.delete(theMovie);
    }

    //Create endpoint that search for a specific movie by title

    public Movie getByName(String name){
        Movie movie= movieRepository.findMovieByName(name);
        if(movie==null){
            throw new APIException("sorry no movie with this name");
        }
        return movie;
    }

//    Create endpoint that returns all movies above that rate

    public List<Movie>getByRate(Integer rating){
        List<Movie>movies=movieRepository.findMovieByRatingGreaterThanEqual(rating);
        return movies;
    }

//    Create endpoint that returns all movies by a specific genre

    public List<Movie> getCategory(String category){
        List<Movie>movies=movieRepository.findMovieByCategory(category);
        if(movies==null){
            throw new APIException("wrong category, try again");
        }
        return movies;
    }




    //Create endpoint that takes movie name and return the duration of the movie
    public Integer getDuration(String name){
        Movie movie= movieRepository.findMovieByName(name);
        if(movie==null){
            throw new APIException("sorry no movie with this name");
        }
      Integer duration= movieRepository.findMovieByName(name).getDuration();
        return duration;
    }

    //Create endpoint that takes movie name and return the rate of the movie

    public Integer getRateOfMovie(String name){
        Movie movie= movieRepository.findMovieByName(name);
        if(movie==null){
            throw new APIException("sorry no movie with this name");
        }
        return movieRepository.findMovieByName(name).getRating();
    }


    //Create endpoint to list movies to a specific director
    public List<Movie> listMoviesByDName(String name){

        if(directorService.findDirectorByName(name)==null){
            throw new APIException("director not found");
        }
        Director dname=directorService.findDirectorByName(name);
        return movieRepository.getMoviesByDirectorID(dname.getId());
    }

    //Create endpoint that takes movie name and return the director name

    public String RetDirectorName(String name){

        if(movieRepository.findMovieByName(name)==null){
            throw new APIException("movie not foumd");
        }

        Director movieN= directorService.findDirectorByID(movieRepository.findMovieByName(name).getDirectorID());
        return movieN.getName();
    }












}
