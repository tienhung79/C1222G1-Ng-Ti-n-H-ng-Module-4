package com.example.empty.service.impl;

import com.example.empty.model.News;
import com.example.empty.repository.INewRepository;
import com.example.empty.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class NewsService implements INewsService {
    @Autowired
    INewRepository newRepository;

    @Override
    public Page<News> getAllNews(Pageable pageable) {
        return newRepository.findAll(pageable);
    }

    @Override
    public void creatNews(News news) {
        newRepository.save(news);
    }

    @Override
    public void deleteNew(int id) {
        newRepository.deleteById(id);
    }
}
