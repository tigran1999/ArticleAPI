package com.task.articleapi.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.task.articleapi.dto.ArticleDto;

public interface ArticleService {

    /**
     *  find all articles by pagination
     *
     * @param pageable page
     *
     * @return list of articles
     */
    List<ArticleDto> findAll(Pageable pageable);

    /**
     *  save an article
     *
     * @param articleDto articleDto
     *
     */
    void save(ArticleDto articleDto);

    /**
     *
     * * @return count of published articles on daily bases for the 7 days
     *
     */
    Long countOfLastWeek();

}
