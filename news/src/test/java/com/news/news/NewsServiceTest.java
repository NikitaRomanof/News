package com.news.news;

import com.news.news.model.DtoModelNews;
import com.news.news.model.ModelNews;
import com.news.news.repository.NewsRepository;
import com.news.news.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class NewsServiceTest {
    @MockBean
    private NewsRepository newsRepository;
    @Autowired
    NewsService newsService;

    @Test
    public void testService() {
        when(newsRepository.findAll()).thenReturn(
                List.of(new ModelNews("title", LocalDate.now(), "body text", null)));

        List<DtoModelNews> allNews = newsService.getAllNews();
        assertEquals("title", allNews.get(0).getTitle());
        assertEquals(LocalDate.now(), allNews.get(0).getDate());
        assertEquals("body text", allNews.get(0).getText());
    }
}
