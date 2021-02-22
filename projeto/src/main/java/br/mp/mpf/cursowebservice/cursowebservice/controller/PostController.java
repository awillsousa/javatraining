package br.mp.mpf.cursowebservice.cursowebservice.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.mp.mpf.cursowebservice.cursowebservice.model.Comment;
import br.mp.mpf.cursowebservice.cursowebservice.model.Post;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	Logger logger = LoggerFactory.getLogger(PostController.class);

	private static List<Post> allPost = initPosts();

	private static List<Post> initPosts() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Post post1 = null;
		Comment comment1 = null;
		Comment comment2 = null;
		try {
			comment1 = Comment.builder()
					.createdAt(simpleDateFormat.parse("20/01/2021 13:10"))
					.id(1)
					.text("How to start learning flutter and spring?")
					.build();
			comment2 = Comment.builder()
					.createdAt(simpleDateFormat.parse("22/01/2021 13:10"))
					.id(1)
					.text("Which one is better React Native or Flutter?")
					.build();
			post1 = Post.builder()
					.createdAt(simpleDateFormat.parse("20/01/2021 13:10"))
					.title("How to build apps in Flutter")
					.content("Flutter is awesome so is Spring Boot")
					.comments(Arrays.asList(comment1, comment2))
					.build();
			comment1.setPost(post1);
			comment2.setPost(post1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Post> postList = new ArrayList<>();
		postList.add(post1);
		return postList;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllPosts() {
		return ResponseEntity.status(HttpStatus.OK).body(allPost);
	}

	@RequestMapping(value = "/xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<?> getAllPostsXML() {
		return ResponseEntity.status(HttpStatus.OK).body(allPost);
	}

	@RequestMapping(value = "/xml", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<?> addPostXML(@RequestBody Post post) {
		PostController.initPosts().add(post);
		return ResponseEntity.status(HttpStatus.OK).body(post);
	}
	
//	<Post>
//	  <id>1</id>
//	  <createdAt>20/01/2021 15:10</createAt>
//	  <content>Flutter is awesome so is Spring Boot</content>
//	  <title>How to build apps in Flutter</title>
//	  <comments>
//	    <comments>
//	      <id>1</id>
//	      <createdAt>20/01/2021 15:10</createdAt>
//	      <text>How to start learning flutter and spring?</text>
//	    </comments>
//	    <comments>
//	      <id>2</id>
//	      <createdAt>22/01/2021 15:10</createdAt>
//	      <text>Which one is better React Native or Flutter?</text>
//	    </comments>
//	  </comments>
//	</Post>

}
