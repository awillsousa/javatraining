package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "Iae mano spring!";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", defaultValue = "fucking hello!") String name) {
        return String.format("Hello %s!", name);
    }


}

