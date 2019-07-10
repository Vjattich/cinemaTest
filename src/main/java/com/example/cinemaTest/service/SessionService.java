package com.example.cinemaTest.service;

import com.example.cinemaTest.model.Session;
import org.springframework.stereotype.Service;

@Service
public interface SessionService {

    Session byId(int id);

}
