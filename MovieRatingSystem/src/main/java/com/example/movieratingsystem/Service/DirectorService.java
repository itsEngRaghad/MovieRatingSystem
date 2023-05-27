package com.example.movieratingsystem.Service;

import com.example.movieratingsystem.APIException.APIException;
import com.example.movieratingsystem.Model.Director;
import com.example.movieratingsystem.Repository.DirectorRipository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRipository directorRipository;

    //-All CRUD

    //get
    public List<Director> getDirectors(){
        return directorRipository.findAll();
    }

    //add
    public void addDirector(Director director){
        directorRipository.save(director);
    }
    //update

    public void updateDirector(Director director, Integer id){
        Director oldDirector=directorRipository.findDirectorById(id);
        if(oldDirector==null){
            throw new APIException("sorry no such Director to update, try another ID");

        }
        oldDirector.setName(director.getName());
        directorRipository.save(oldDirector);
    }
    //delete

    public void deleteDirector(Integer id){
        Director theDirector= directorRipository.findDirectorById(id);
        if (theDirector==null){
            throw new APIException("this Director Doesn't exist, try another id");
        }

        directorRipository.delete(theDirector);
    }

//    public Director directorID(Integer id){
//        directorRipository.findDirectorById(id);
//        return
//    }

    public Director findDirectorByID(Integer id){
        return directorRipository.findDirectorById(id);
    }

    public Director findDirectorByName(String name){
        return directorRipository.getDirectorByName(name);
    }
}
