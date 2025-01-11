package com.proyecto.consumo_api.controller;

import com.proyecto.consumo_api.dto.PostDto;
import com.proyecto.consumo_api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/post")
    public ResponseEntity<List<PostDto>> getPosts() {
        return new ResponseEntity<>(postService.getPosts(),HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer id) {
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.savePost(postDto),HttpStatus.CREATED);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Integer id, @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.updatePost(id,postDto),HttpStatus.OK);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post eliminado!",HttpStatus.OK);
    }
}
