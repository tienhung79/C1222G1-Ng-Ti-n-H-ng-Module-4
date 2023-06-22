package com.example.empty.service;

import com.example.empty.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INewsService {
    Page<News> getAllNews(Pageable pageable);

    void creatNews(News news);

    void deleteNew(int id);
}
