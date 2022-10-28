This project consists of 3 endpoints which will fetch the News Articles details by hitting the GNews API.

How to start the project???
> Download the project from github -
> Open in Intellij IDEA and navigate to NewsApiApplication.java
> Right click and select Run NewsApiApplication.main()
> Tomcat should be starting on port number 8080 and application is deployed.

Please test the below endpoints in Postman by using the example endpoints given.
Please refer to NewsAPI Collection.postman_collection.json, import in Postman and test to check the results.

#API - getArticlesByCount
Description - This API will fetch N news articles where N is the input entered by the user in the path parameter.
Example Endpoint - http://localhost:8080/newsapi/articles/10

#API - getArticlesByTitle
Description - This API will fetch all those news articles where the search key provided by the user is present in
the 'title' attribute.
Example Endpoint - http://localhost:8080/newsapi/articles/title/Zac Efron

#API - getArticlesBySearchKey
Description - This API will fetch all those news articles where the search key provided by the user is present in
any of the response attributes
Example Endpoint - http://localhost:8080/newsapi/articles/search/depression
