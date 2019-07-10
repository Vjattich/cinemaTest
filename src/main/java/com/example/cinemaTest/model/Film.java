package com.example.cinemaTest.model;


import com.example.cinemaTest.enums.Genre;
import com.example.cinemaTest.model.dto.SessionDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.EnumType.*;
import static javax.persistence.GenerationType.*;

@Data
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column
    private int popularity;

    @Column(nullable = false)
    @Enumerated(STRING)
    private Genre genre;

    @Column
    private String description;

    @Column(nullable = false)
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Session> sessions;

}
