package com.example.demo.controller;

import com.example.demo.model.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class ProjectController {

    public static ArrayList<Project> allProjects = new ArrayList<Project>();

    @PostMapping()
    @RequestMapping("/addProject")
    public ResponseEntity<Project> createProject(@RequestBody @Valid Project project) {
        ResponseEntity responseEntity;
        if (project != null) {
            ProjectController.allProjects.add(project);
        }
        return null;
    }

}
