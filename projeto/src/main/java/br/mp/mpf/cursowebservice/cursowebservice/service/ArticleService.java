package br.mp.mpf.cursowebservice.cursowebservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.mp.mpf.cursowebservice.cursowebservice.model.Article;

@Service
public class ArticleService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Article> getAllArticles() {
		List<Article> articles = new ArrayList<>();
		Article[] allArticles = this.restTemplate.getForObject("https://601bf68c1a9c22001706003e.mockapi.io/articles",
				Article[].class);
		articles.addAll(Arrays.asList(allArticles));
		return articles;
	}

	public List<Article> retriveAllArticles() {
		List<Article> articles = new ArrayList<>();
		Article[] allArticles = this.restTemplate.getForObject("https://601bf68c1a9c22001706003e.mockapi.io/articles",
				Article[].class);
		articles.addAll(Arrays.asList(allArticles));
		return articles;
	}

	public Article createArticle(Article article) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity request = new HttpEntity(article, headers);

		Article articleCreated = this.restTemplate.postForObject(
				"https://601bf68c1a9c22001706003e.mockapi.io/articles",
				request,
				Article.class);

		return articleCreated;
	}
}