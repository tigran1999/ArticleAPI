package com.task.articleapi;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.task.articleapi.dto.ArticleDto;
import com.task.articleapi.entity.Article;
import com.task.articleapi.mapper.ArticleEntityMapper;
import com.task.articleapi.mapper.MapstructArticleMapper;
import com.task.articleapi.repository.ArticleRepository;
import com.task.articleapi.service.impl.ArticleServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class ArticleApiApplicationTests {

    @InjectMocks
    ArticleServiceImpl articleService;

    @Mock
    ArticleRepository articleRepository;

    @Mock
    private Pageable pageableMock;

    @Mock
    private ArticleEntityMapper articleEntityMapper;

    @Before
    public void init() {
        articleService = new ArticleServiceImpl(articleRepository, articleEntityMapper);
    }

    @Test
    public void test_createArticle() {
        LocalDate publicationDate = LocalDate.of(2019, Month.APRIL, 22);
        ArticleDto articleDto = new ArticleDto(1L, "some title", "John", "some content", publicationDate);
        articleService.save(articleDto);
        verify(articleRepository, times(1)).save(articleEntityMapper.map(articleDto));
    }

    @Test
    public void  test_getAllArticlesByPage() {
        List<Article> list = new ArrayList<>();
        Article articel1 = new Article(1L, "title1", "John", "content1", LocalDate.now().minus(Period.ofDays(1)));
        Article article2 = new Article(2L, "title2", "Sebastian", "content2", LocalDate.now().minus(Period.ofDays(3)));
        Article article3 = new Article(3L, "title3", "Tramp", "content3", LocalDate.now().minus(Period.ofDays(2)));

        list.add(articel1);
        list.add(article2);
        list.add(article3);

        Page<Article> articlePage =new PageImpl<>(list, pageableMock, list.size());
        when(articleRepository.findAll(pageableMock)).thenReturn(articlePage);
        List<ArticleDto> all = articleService.findAll(pageableMock);
        assertEquals(articlePage.getSize(),all.size());
    }

}
