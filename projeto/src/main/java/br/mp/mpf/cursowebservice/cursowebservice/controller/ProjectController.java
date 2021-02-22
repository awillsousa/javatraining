package br.mp.mpf.cursowebservice.cursowebservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mp.mpf.cursowebservice.cursowebservice.model.Project;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

	Logger logger = LoggerFactory.getLogger(ProjectController.class);

	public static ArrayList<Project> allProjects = new ArrayList<>(Arrays.asList(
			Project.builder().id(1).name("Zetta Project").build(), 
			Project.builder().id(2).name("Ufla Project").build(),
			Project.builder().id(3).name("Mac Project").build()));

	@GetMapping() // produces = MediaType.APPLICATION_JSON_VALUE por default
	public ResponseEntity<List<Project>> getProjects() {
		logger.info("Entrou no getProjects");
		logger.info("Saiu do getProjects");
		return ResponseEntity.ok().body(ProjectController.allProjects);
	}

	@PostMapping() // produces e consumes = MediaType.APPLICATION_JSON_VALUE por default
	public ResponseEntity<Project> createProject(@RequestBody @Valid Project project) {
		ResponseEntity<Project> responseEntity;
		logger.info("Entrou no metodo createProject");
		if (project != null) {
			ProjectController.allProjects.add(project);
			responseEntity = ResponseEntity.ok(project);
		} else {
			responseEntity = ResponseEntity.badRequest().build();
		}
		logger.info("Saimos do metodo createProject");
		return responseEntity;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable(name = "id") Integer id, @RequestBody Project project) {
		ResponseEntity<Project> responseEntity = null;
		logger.info("Entrou no updateProject");
		if (project != null) {
			if (id > ProjectController.allProjects.size()) {
				responseEntity = ResponseEntity.badRequest().build();
			} else {
				Project projectToUpdate = ProjectController.allProjects.get(id);
				ProjectController.allProjects.remove(projectToUpdate);
				projectToUpdate = project;
				ProjectController.allProjects.add(projectToUpdate);
				responseEntity = ResponseEntity.ok(project);
			}
		} else {
			responseEntity = ResponseEntity.badRequest().build();
		}
		logger.info("Saiu do update Project");

		return responseEntity;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<List<Project>> deleteProject(@PathVariable Integer id) { // posso deixar sem name se os nomes forem iguais
		ResponseEntity<List<Project>> responseEntity = null;
		logger.info("Entrou no deleteProject");
		if (id >= ProjectController.allProjects.size()) {
			responseEntity = ResponseEntity.badRequest().build();
		} else {
			Project projectToDelete = ProjectController.allProjects.get(id);
			ProjectController.allProjects.remove(projectToDelete);
			responseEntity = ResponseEntity.ok(allProjects);
		}
		logger.info("Saiu do delete Project");

		return responseEntity;
	}

}
