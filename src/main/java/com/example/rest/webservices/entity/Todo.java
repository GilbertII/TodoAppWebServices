package com.example.rest.webservices.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Todo {

    private Long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;

}
