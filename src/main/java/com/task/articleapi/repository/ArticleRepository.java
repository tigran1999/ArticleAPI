package com.task.articleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.task.articleapi.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "select count(a) from articles a where  a.publication_date >= NOW() - INTERVAL '1 WEEK' and a.publication_date <= NOW()", nativeQuery = true)
    Long countOfLastWeek();

}
