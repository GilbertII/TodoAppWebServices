package com.example.rest.webservices.services;

import com.example.rest.webservices.entity.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


@Service
@Slf4j
public class TodoHardcodeServiceImpl implements TodoHardcodeService {

    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;

    {
        // TODO: 6/7/2022
        todos.add(new Todo(++idCounter, "GII", "Learn Spring Boot", new Date(), false));
        todos.add(new Todo(++idCounter, "GII", "Learn React JS", new Date(), false));
        todos.add(new Todo(++idCounter, "GII", "Learn JavaScript", new Date(), false));
    }

    @Override
    public List<Todo> findAll() {
        return todos;
    }
}
