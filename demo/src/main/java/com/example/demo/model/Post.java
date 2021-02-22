package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Post  {
    private Integer id;
    private String content;
    private String description;
    private String title;
    @JsonFormat(pattern="dd/mm/YYYY HH:MM")
    private Date createdAt;
    private List<Comment> comments = new ArrayList<Comment>();
}
