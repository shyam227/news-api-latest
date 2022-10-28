package com.news.newsapi.controller;

import com.news.newsapi.model.NewsResponse;
import com.news.newsapi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    /*
      This API will fetch N news articles where N is the input entered by the user in the path parameter
     */
    @GetMapping("/articles/{count}")
    public NewsResponse getArticlesByCount(@PathVariable("count") int count){

        NewsResponse newsResponse = newsService.getArticlesByCount(count);
        return newsResponse;
    }

    /*
      This API will fetch all those news articles where the search key provided by the user is present in
      the 'title' attribute
     */
    @GetMapping("/articles/title/{title}")
    public NewsResponse getArticlesByTitle(@PathVariable("title") String title){

        NewsResponse newsResponse = newsService.getArticlesByTitle(title);
        return newsResponse;
    }

    /*
     This API will fetch all those news articles where the search key provided by the user is present in
     any of the response attributes
     */
    @GetMapping("/articles/search/{key}")
    public NewsResponse getArticlesBySearchKey(@PathVariable("key") String key){

        NewsResponse newsResponse = newsService.getArticlesBySearchKey(key);
        return newsResponse;
    }
}
