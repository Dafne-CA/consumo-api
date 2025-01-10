package com.proyecto.consumo_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostDto {
    private Integer id;
    private String title;
    private String body;
    private Integer userId;

}
