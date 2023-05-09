package com.news.news.repository;

import com.news.news.model.ModelNews;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

//  Interface for actions with the database.
@Repository
public interface NewsRepository extends CrudRepository<ModelNews, Long> {

    //  Get all news from the database.
    @Override
    @NonNull
    List<ModelNews> findAll();
}
