package com.example.cinemaTest.dao;

import com.example.cinemaTest.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    Session findById(int id);
}
