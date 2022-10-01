package com.task.articleapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.task.articleapi.dto.ArticleDto;
import com.task.articleapi.entity.Article;
import com.task.articleapi.mapper.ArticleEntityMapper;
import com.task.articleapi.repository.ArticleRepository;
import com.task.articleapi.service.ArticleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;

    @Override
    public List<ArticleDto> findAll(Pageable pageable) {
        List<Article> articles = articleRepository.findAll(pageable).getContent();
        return articles.stream().map(articleEntityMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void save(ArticleDto articleDto) {
        Article article = articleEntityMapper.map(articleDto);

        articleRepository.save(article);
    }

    @Override
    public Long countOfLastWeek() {
        return articleRepository.countOfLastWeek();
    }
}
