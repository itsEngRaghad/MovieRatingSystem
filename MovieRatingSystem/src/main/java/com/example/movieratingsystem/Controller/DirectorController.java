package com.example.movieratingsystem.Controller;

import com.example.movieratingsystem.Model.Director;
import com.example.movieratingsystem.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    //get
    @GetMapping("/get")
    public ResponseEntity getDirectors(){

        List<Director> directors=directorService.getDirectors();
        return ResponseEntity.status(200).body(directors);
    }

    //add

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director){
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Congrats!, Director has been successfully added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@Valid @RequestBody Director director,@PathVariable Integer id){
        directorService.updateDirector(director,id);
        return ResponseEntity.status(200).body("your Director has been successfully updated!");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id){
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Sadly, Director has been deleted");
    }

}
