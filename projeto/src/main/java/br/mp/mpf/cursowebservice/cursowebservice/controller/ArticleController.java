package br.mp.mpf.cursowebservice.cursowebservice.controller;

import br.mp.mpf.cursowebservice.cursowebservice.model.Article;
import br.mp.mpf.cursowebservice.cursowebservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return this.articleService.retriveAllArticles();
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody Article article) {
        Article createdArticle = this.articleService.createArticle(article);
        return ResponseEntity.ok(createdArticle);
    }


}
