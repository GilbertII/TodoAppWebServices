package com.example.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();

        for (int i = 0; i < 10; i++) {
            String encodedString = cryptPasswordEncoder.encode("user");
            System.out.println(encodedString);
        }

    }
}
