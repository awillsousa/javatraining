package br.mp.mpf.cursowebservice.cursowebservice.controller;

import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.mp.mpf.cursowebservice.cursowebservice.model.Project;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class ProjectControllerTest {

	@Autowired
	MockMvc mvc;

	static String PROJECT_API = "/projects";

	@Test
	@DisplayName("Deve criar um Project com sucesso.")
	public void createProjectTest() throws Exception {
		Project project = Project.builder()
				.id(14)
				.name("Project Test")
				.email("rafael.durelli@ufla.br")
				.build();

		String json = new ObjectMapper().writeValueAsString(project);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post(PROJECT_API)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(json);

		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(jsonPath("name").isNotEmpty())
				.andExpect(jsonPath("email").isNotEmpty())
				.andExpect(jsonPath("name").value(project.getName()))
				.andExpect(jsonPath("email").value(project.getEmail()))
				.andDo(print());

	}

	@Test
	@DisplayName("Deve lançar um erro (ApiErrors) quando name e password forem inválido")
	public void createInvalidProjectTest() throws Exception{
        Project project = Project.builder()
                .id(14)
                .name("P")
                .email("r")
                .build();

        String json = new ObjectMapper().writeValueAsString(project);
        
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(PROJECT_API)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(json);

        mvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errorCount").value(2))
                .andExpect(jsonPath("code", ArgumentMatchers.contains("400")).value("400 BAD_REQUEST"))
                .andExpect(jsonPath("messages", hasSize(2)))
                .andExpect(jsonPath("messages[0]").value("Provide a valid e-mail"))
                .andDo(print());

    }
}
