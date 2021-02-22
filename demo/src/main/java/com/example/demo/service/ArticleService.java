package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArticleService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Article> retrieveAllArticles() {
        List<Article> articles = new ArrayList<>();
        Article[] allArticles = this.restTemplate.getForObject(

        )
        return }



}
