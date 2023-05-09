package com.news.news.service;

import com.news.news.model.ModelNews;
import com.news.news.repository.NewsRepository;
import org.springframework.stereotype.Service;
import com.news.news.model.DtoModelNews;

import java.util.ArrayList;
import java.util.List;

//  Service class. Wraps the interface for working with the repository
@Service
public class NewsService {
    private final NewsRepository repository;

    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }

    public List<DtoModelNews> getAllNews() {
        List<DtoModelNews> allNews = new ArrayList<>();

        // Converting received news from the database to a list transfer objects.
        for (ModelNews entityModel : repository.findAll()) {
            allNews.add(new DtoModelNews(entityModel));
        }
        return allNews;
    }

    public void create(ModelNews news) {
        repository.save(news);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
