package com.task.articleapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.task.articleapi.dto.ArticleDto;
import com.task.articleapi.entity.Article;

@Mapper(componentModel = "spring", implementationName = "MapstructArticleMapper")
public interface ArticleEntityMapper  {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "publicationDate", source = "publicationDate")
    @Mapping(target = "author", source = "author")
    Article map(ArticleDto dto) ;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "publicationDate", source = "publicationDate")
    @Mapping(target = "author", source = "author")
    ArticleDto mapToDto(Article entity);

}
