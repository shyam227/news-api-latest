package com.news.newsapi.service;

import com.news.newsapi.model.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class NewsService {

    @Autowired
    private RestTemplate restTemplate;

    private static HashMap<String, NewsResponse> cacheMap = new HashMap<String, NewsResponse>();

    public NewsResponse getArticlesByCount(int count){

        NewsResponse newsResponse = null;

        String apiToken = "9e2a15e6c49d945108884fa010b3f16e";
        String gNewsUrl = "https://gnews.io/api/v4/search?q=None&token="+apiToken+"&lang=en&country=us&max="+count;

        newsResponse = getDataFromCache("getArticlesByCount"+count);
        if(newsResponse == null){
            newsResponse = restTemplate.getForObject(gNewsUrl, NewsResponse.class);
            updateCache("getArticlesByCount"+count, newsResponse);
        }
        return newsResponse;
    }

    public NewsResponse getArticlesByTitle(String titleKeyword){

        NewsResponse newsResponse = null;

        String apiToken = "9e2a15e6c49d945108884fa010b3f16e";
        String gNewsUrl = "https://gnews.io/api/v4/search?q="+titleKeyword+"&token="+apiToken+"&lang=en&country=us&in=title";

        newsResponse = getDataFromCache("getArticlesByTitle"+titleKeyword);
        if(newsResponse == null){
            newsResponse = restTemplate.getForObject(gNewsUrl, NewsResponse.class);
            updateCache("getArticlesByTitle"+titleKeyword, newsResponse);
        }

        return newsResponse;
    }
    public NewsResponse getArticlesBySearchKey(String key){

        NewsResponse newsResponse = null;

        String apiToken = "9e2a15e6c49d945108884fa010b3f16e";
        String gNewsUrl = "https://gnews.io/api/v4/search?q="+key+"&token="+apiToken+"&lang=en&country=us";

        newsResponse = getDataFromCache("getArticlesBySearchKey"+key);
        if(newsResponse == null){
            newsResponse = restTemplate.getForObject(gNewsUrl, NewsResponse.class);
            updateCache("getArticlesBySearchKey"+key, newsResponse);
        }
        return newsResponse;
    }

    public NewsResponse getDataFromCache(String key){
        if(cacheMap.get(key) != null){
            System.out.println("Fetching from Cache");
            return cacheMap.get(key);
        }
        return null;
    }

    public void updateCache(String key, NewsResponse newsResponse){
        System.out.println("Updating Cache");
        cacheMap.put(key, newsResponse);
    }
}
