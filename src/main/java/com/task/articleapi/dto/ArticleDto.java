package com.task.articleapi.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {


    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDate publicationDate;

}

