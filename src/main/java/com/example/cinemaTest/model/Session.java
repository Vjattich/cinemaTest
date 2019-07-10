package com.example.cinemaTest.model;


import com.example.cinemaTest.enums.City;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.*;

@Data
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column
    @Enumerated(STRING)
    private City city;

    @Column
    @Temporal(TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = LAZY)
    private Film film;

}
