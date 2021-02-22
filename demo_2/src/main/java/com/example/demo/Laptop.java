package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private Integer id;
    private String type;

    public Laptop() {
    }

    public Laptop(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void ShowingData() {
        System.out.println("Exibindo dados do laptop...");
    }

}
