package br.mp.mpf.cursowebservice.cursowebservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {

    private Integer id;
    
	@NotNull(message = "{project.name.notempty}")
	@Size(min = 3, max = 150, message="Name should be between {min} and {max} chars")
    private String name;
    
    @Email(message = "Provide a valid e-mail")
    private String email;
}
