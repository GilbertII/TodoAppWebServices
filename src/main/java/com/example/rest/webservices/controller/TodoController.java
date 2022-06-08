package com.example.rest.webservices.controller;

import com.example.rest.webservices.entity.Todo;
import com.example.rest.webservices.services.TodoHardcodeService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/todo")
@CrossOrigin( origins = "http://localhost:4200")
@Slf4j
@Data
public class TodoController {

    private final TodoHardcodeService todoHardcodeService;


    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        List<Todo> todos = todoHardcodeService.findAll().stream()
                .filter(todo-> todo.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());

        return todos;
    }


}
