package com.example.cinemaTest.service.impl;

import com.example.cinemaTest.dao.SessionRepository;
import com.example.cinemaTest.model.Session;
import com.example.cinemaTest.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository repository;

    @Override
    public Session byId(int id) {
        return repository.findById(id);
    }
}
