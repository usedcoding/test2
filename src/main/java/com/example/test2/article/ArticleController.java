package com.example.test2.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @GetMapping("/article/create")
    public String create() {
        return"article_create";
    }

    @PostMapping("/article/create/{id}")
    public String create(Model model,@PathVariable Integer id, @RequestParam String subject,@RequestParam String content) {
        this.articleService.getSave(subject, content);
        return"redirect:/article/list";
    }

}
