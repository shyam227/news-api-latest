package com.news.newsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsArticle {

    private String title;
    private String description;
    private String content;
    private String url;
    private String image;
    private String publishedAt;
    private ArticleSource source;

}
