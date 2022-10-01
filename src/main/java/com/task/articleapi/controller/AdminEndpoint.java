package com.task.articleapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.articleapi.service.ArticleService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminEndpoint {

    private final ArticleService articleService;

    @Operation(description = "The endpoint should return count of published articles on daily bases for the 7 days")
    @GetMapping("/statistics")
    public Long getStatistics() {
        return articleService.countOfLastWeek();
    }
}
