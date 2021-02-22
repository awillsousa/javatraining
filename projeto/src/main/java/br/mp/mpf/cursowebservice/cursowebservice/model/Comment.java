package br.mp.mpf.cursowebservice.cursowebservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
	
	private Integer id;
	private String text;
	private Date createdAt;
	
	@JsonManagedReference
	@JsonBackReference
	private Post post;

}
