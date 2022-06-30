package com.example.rest.webservices.restfulwebservices.controller;

import com.example.rest.webservices.restfulwebservices.entity.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/hello")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
public class HelloController {

    @GetMapping("getHelloWorld")
    public String getHelloWorld() {
        return "Hello world!";
    }

    @GetMapping("getHelloWorldBean")
    public HelloWorldBean getHelloWorldBean() {
        return new HelloWorldBean("Hellow Wold With Bean");
    }

    @GetMapping("getHelloWorldBeanPathVar/{name}")
    public HelloWorldBean getHelloWorldBeanPathVar(@PathVariable String name) {


//        throw  new RuntimeException("Something went wrong!");
        return new HelloWorldBean(String.format("Hellow Wold With Bean, %s", name));
    }

}
