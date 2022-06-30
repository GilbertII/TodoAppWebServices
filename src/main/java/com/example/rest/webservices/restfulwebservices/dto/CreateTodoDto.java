package com.example.rest.webservices.restfulwebservices.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateTodoDto {

    private String username;
    private String description;
    private Date targetDate;
    private Boolean isDone;

}
