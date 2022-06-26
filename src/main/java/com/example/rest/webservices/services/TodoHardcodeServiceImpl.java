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

    private static final List<Todo> todos = new ArrayList();
    private static long idCounter = 0;

    static {
        // TODO: 6/7/2022
        todos.add(new Todo(++idCounter, "user", "Learn Spring Boot", new Date(), false));
        todos.add(new Todo(++idCounter, "user", "Learn React JS", new Date(), false));
        todos.add(new Todo(++idCounter, "user", "Learn JavaScript", new Date(), false));
    }

    @Override
    public List<Todo> findAll() {
        return todos;
    }

    @Override
    public Todo findById(Long id){
        return todos.stream().filter(todo-> todo.getId().compareTo(id) ==0).findFirst().get();
    }

    @Override
    public Todo deleteById(Long id) {
        Todo todo = findById(id);

        if (todo==null) return null;

        todos.remove(todo);
        return todo;
    }

    @Override
    public Todo saveOrUpdateTodo(Todo todo) {

        if (todo.getId() == null || (todo.getId() == -1 || todo.getId() == 0)) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            Todo updateTodo = findById(todo.getId());
            updateTodo.setDescription(todo.getDescription());
            updateTodo.setUsername(todo.getUsername());
            updateTodo.setTargetDate(todo.getTargetDate());
            updateTodo.setDone(todo.isDone());
        }

        return todo;
    }
}
