# Spring Boot Demo 

## Just a demo to integrate Mybatis Plus, H2 Database, Redis Template, Lettuce to show the simple use case

## Requirements
Benefit from embedded database and embedded redis server, 
JDK 8 and Lombok plugin is all you need.
Because RabbitMq don't have an embedded middleware, and Spring Cloud need more than one middleware,
It is not easy to run the demo instantly.

## Middleware
- embedded h2 database 
- embedded redis 

## Frameworks
- Spring-boot-web
- Spring-boot-redis
- Mybatis-plus-Spring-boot
- JSoup


## Douban Books Test Urls:
when application is ready, the event listeners call method to crawl Douban Top 250 books
- [getPageBooks](http://localhost:8080/book/getPage?pageNo=1&pageSize=6)
- [getPageBooksRestful](http://localhost:8080/book/restPage/6/2)
- [queryBookByBookName](http://localhost:8080/book/queryByName?bookName=%E7%BA%A2%E6%A5%BC%E6%A2%A6)

## Redis Test Urls
- [testLettuceSetNxEx](http://localhost:8080/redis/testSetNxEx)
- [testLettuceTimedAsync](http://localhost:8080/redis/testAsync)
- [testLettuceAsync](http://localhost:8080/redis/testAsync2)
- [testRedisTemplate](http://localhost:8080/redis/testTemplate)