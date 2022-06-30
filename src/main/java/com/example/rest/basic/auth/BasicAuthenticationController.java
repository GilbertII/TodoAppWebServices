package com.example.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// @RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController {

    @GetMapping("/basicauth")
    public AuthenticationBean getHelloWorldBean() {
        return new AuthenticationBean("You've been authenticated!");
    }


}
