package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    public static List<Post> posts = PostController.initPosts();

    private static java.util.List<Post> initPosts(){
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

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/allposts")
    public ResponseEntity<?> getAllPost() {
            return ResponseEntity.ok(PostController.initPosts());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE, value="/postxml")
    public ResponseEntity<?> getAllPostXML() {
        return ResponseEntity.ok(PostController.initPosts());
    }

    public ResponseEntity<?> addPostXMLL(@RequestBody Post post) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            Post post1 = Post.builder()
                    .createdAt(simpleDateFormat.parse("20/01/2021 13:10"))
                    .title("How to build apps in Flutter")
                    .content("Flutter is awesome so is Spring Boot")
                    .build();
            PostController.posts.add(post1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("Post inserido com sucesso!");

    }

}
