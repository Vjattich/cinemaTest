package com.example.cinemaTest.model;


import lombok.Data;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.*;
import static javax.persistence.TemporalType.*;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer place;

    @OneToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;

    @Column(nullable = false)
    private String ownerEmail;

    @Column(nullable = false)
    private String ownerPhoneNumber;

    @Column(nullable = false)
    @Temporal(TIMESTAMP)
    private Date creationDate;

}
