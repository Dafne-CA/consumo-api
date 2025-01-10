package com.proyecto.consumo_api.service;

import com.proyecto.consumo_api.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final RestTemplate restTemplate;

    //metodo para obtener todos los post

    public List<PostDto> getPosts() {
        ResponseEntity<List<PostDto>> response = restTemplate.exchange("https://jsonplaceholder.typicode.com/users/1/posts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PostDto>>() {}
        );
        return response.getBody();
    }

    //metodo para obtener un post por id
    public PostDto getPostById(Integer id) {
        return restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/" + id, PostDto.class).getBody();
    }

    //metodo para guardar post
    public PostDto savePost(PostDto postDto) {
        return restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", postDto, PostDto.class);
    }

    //metodo para actualiza post
    /*
    public void updatePost(Integer id, PostDto postDto) {
        restTemplate.put("https://jsonplaceholder.typicode.com/posts/" + id, postDto);
    }
    */

    //metodo para actualiza post - recomendable porque se usa en cualquier tipo de solicitud el exchange()
    public PostDto updatePost(Integer id, PostDto postDto) {
        HttpEntity<PostDto>  httpEntity= new HttpEntity<>(postDto);
        ResponseEntity<PostDto> response= restTemplate.exchange("https://jsonplaceholder.typicode.com/posts/"+id,
                HttpMethod.PUT,
                httpEntity,
                PostDto.class);
        return response.getBody();
    }

    //metodo para eliminar post
    public void deletePost(Integer id) {
        restTemplate.delete("https://jsonplaceholder.typicode.com/posts/"+id);
    }



}
