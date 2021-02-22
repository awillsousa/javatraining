package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Component
@Scope(value = "prototype")
public class Funcionario {
    private Integer id;
    private String name;
    private Double salary;

    @Autowired
    private Laptop laptop;

    public Funcionario() {
        System.out.println("Funcionario criado!");
    }


    public Funcionario(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
    }

    public void show() {
        System.out.println("Exibindo, bindo, bindo...");
    }
}
