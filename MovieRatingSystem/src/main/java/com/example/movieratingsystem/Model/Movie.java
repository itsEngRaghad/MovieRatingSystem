package com.example.movieratingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {

//Movie Class : ID, name , genre , rating , duration , directorID

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2)
    @Column(columnDefinition = "varchar(15) check ( name >= 2 )")
    private String name ;

    @Column(columnDefinition = "varchar(15) not null check(category='drama' or category='action' or category='comedy')")
    private String category;

    @Min(5)
    @Column(columnDefinition = "int default 5 check ( rating <= 5 )")
    private Integer rating ;


    @Min(60)
    @Column(columnDefinition = "int default 60 check ( duration >= 60 )")
    private Integer duration ;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer DirectorID;



}
