package com.example.test2.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public void getSave(String content, String subject){
        Article a = new Article();
        a.setContent(content);
        a.setSubject(subject);
        a.setCreateDate(LocalDateTime.now());

        this.articleRepository.save(a);
    }

    public List<Article> getList() {
        return this.articleRepository.findAll();
    }
}
