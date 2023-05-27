package com.example.movieratingsystem.Repository;

import com.example.movieratingsystem.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRipository extends JpaRepository<Director,Integer> {

    Director findDirectorById(Integer id); //yes

    Director getDirectorByName(String name);

}
