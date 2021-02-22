package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {
    private Integer id;

    @NotNull(message = "Nome não pode ser nulo.")
    @Size(min = 3, max = 150, message = "Tamanho do nome deve ser entre 3 e 150")
    private String name;

    @Email(message = "Digite um email válido")
    private String email;

}
