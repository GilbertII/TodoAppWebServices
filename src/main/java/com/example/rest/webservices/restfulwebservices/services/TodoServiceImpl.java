package com.example.rest.webservices.restfulwebservices.services;

import com.example.rest.webservices.restfulwebservices.dto.CreateTodoDto;
import com.example.rest.webservices.restfulwebservices.dto.UpdateTodoDto;
import com.example.rest.webservices.restfulwebservices.entity.Todo;
import com.example.rest.webservices.restfulwebservices.repository.TodoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Slf4j
@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found!"));
    }

    @Override
    public Todo deleteById(Long id) {
        Todo todo = findById(id);

        if (todo == null) new RuntimeException("Todo not found!");

        todoRepository.deleteById(id);

        return todo;
    }

    @Override
    public Todo saveOrUpdateTodo(Todo todo) {

        if (todo.getId() == null || (todo.getId() == -1 || todo.getId() == 0)) {
            todoRepository.save(todo);
        } else {
            Todo updateTodo = findById(todo.getId());
            updateTodo.setDescription(todo.getDescription());
            updateTodo.setUsername(todo.getUsername());
            updateTodo.setTargetDate(todo.getTargetDate());
            updateTodo.setDone(todo.isDone());
            todoRepository.save(updateTodo);
        }

        return todo;
    }

    @Override
    public List<Todo> findAllByUsername(String username) {
        return todoRepository.findAllByUsername(username);
    }

    @Override
    public Todo createTodo(CreateTodoDto createTodoDto) {
        Todo todo = objectMapper.convertValue(createTodoDto, Todo.class);

        todoRepository.save(todo);

        return todo;
    }

    @Override
    public Todo updateTodo(UpdateTodoDto updateTodoDto) {
        Todo todo = objectMapper.convertValue(updateTodoDto, Todo.class);
        Todo updateTodo = findById(todo.getId());

        if (todo == null) new RuntimeException("Todo not found!");

        updateTodo.setDescription(todo.getDescription());
        updateTodo.setUsername(todo.getUsername());
        updateTodo.setTargetDate(todo.getTargetDate());
        updateTodo.setDone(todo.isDone());
        todoRepository.save(updateTodo);

        return todo;
    }
}
