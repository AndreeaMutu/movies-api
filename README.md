# movies-api readme
Docker demo - spring boot app with postgresql database for storing and reading favorite movies
Week 2 assignment of https://github.com/datastaxdevs/docker-learning-path/tree/master/week-2

docker-compose up -d

SWAGGER http://localhost:8080/swagger-ui/index.html 

* GET /movies
* POST /movie 

```
{
  "title": "string",
  "description": "string",
  "rating": 0,
  "releaseDate": "2020-10-10"
}
```
