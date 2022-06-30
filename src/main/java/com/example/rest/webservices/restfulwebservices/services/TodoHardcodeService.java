package com.example.rest.webservices.restfulwebservices.services;

import com.example.rest.webservices.restfulwebservices.entity.Todo;

import java.util.List;

public interface TodoHardcodeService {

    public List<Todo> findAll();

    public Todo findById(Long id);

    public Todo deleteById(Long id);

    public Todo saveOrUpdateTodo(Todo todo);

}
