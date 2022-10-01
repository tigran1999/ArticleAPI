package com.task.articleapi.controller;


import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.articleapi.dto.ArticleDto;
import com.task.articleapi.service.ArticleService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleEndpoint {

    private final ArticleService articleService;

    @GetMapping
    @Operation(description = "Get all articles by pagination")
    public List<ArticleDto> getAll(@RequestParam int page, @RequestParam int size) {
        return articleService.findAll(PageRequest.of(page, size));
    }

    @PostMapping
    @Operation(description = "Save an article")
    public void save(@Valid @RequestBody ArticleDto articleDto) {
        articleService.save(articleDto);
    }
}
