package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.model.Project;
import org.hamcrest.Matchers;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class ProjectController2Test {

    @Autowired
    MockMvc mvc;

    static String PROJECT_API = "/projects";

    @Test
    @DisplayName("Deve criar um Project com sucesso.")
    public void createProjectTest() throws Exception{
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
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(project.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("email").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("email").value(project.getEmail()))
                .andDo(MockMvcResultHandlers.print());

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
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("errorCount").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("code", ArgumentMatchers.contains("400")).value("400 BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("messages", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("messages[0]").value("Provide a valid E-mail"))
                .andDo(MockMvcResultHandlers.print());

    }
}