package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestService {

    @GetMapping("/greetings")
    public String greetings() {
        return "Hello World";
    }

    @GetMapping("/testing")
    public String testing(){
        return "testing is working";
    }
}
