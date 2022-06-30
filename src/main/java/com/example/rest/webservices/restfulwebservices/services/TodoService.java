package com.example.rest.webservices.restfulwebservices.services;

import com.example.rest.webservices.restfulwebservices.dto.CreateTodoDto;
import com.example.rest.webservices.restfulwebservices.dto.UpdateTodoDto;
import com.example.rest.webservices.restfulwebservices.entity.Todo;

import java.util.List;

public interface TodoService {

    public List<Todo> findAll();

    public Todo findById(Long id);

    public Todo deleteById(Long id);

    public Todo saveOrUpdateTodo(Todo todo);

    public List<Todo> findAllByUsername(String username);

    public Todo createTodo(CreateTodoDto createTodoDto);

    public Todo updateTodo(UpdateTodoDto updateTodoDto);

}
