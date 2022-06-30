package com.example.rest.webservices.restfulwebservices.repository;

import com.example.rest.webservices.restfulwebservices.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<Todo> findById(long id);

    List<Todo> findAllByUsername(String username);

}
