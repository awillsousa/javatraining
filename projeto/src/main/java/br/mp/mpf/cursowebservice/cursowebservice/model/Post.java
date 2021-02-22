package br.mp.mpf.cursowebservice.cursowebservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class Post {
	
	private Integer id;
	private String content;
	private String description;
	private String title;
	
	//@JsonFormat("dd/MM/yyyy HH:mm")
	private Date createdAt;
	
	@JsonManagedReference
	@JsonBackReference
	private List<Comment> comments = new ArrayList<>();

}
