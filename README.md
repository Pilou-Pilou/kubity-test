# Kubity Test Project

## Launch App

```
mvn spring-boot:run
```

### Use Api

You can use a client rest or go to this url : <a href="http://www.siteduzero.com">Swagger</a> [Swagger](http://127.0.0.1:8080/swagger-ui.html)

### Exemple of request 

```
GET http://127.0.0.1:8080/api/users
```

```
GET http://127.0.0.1:8080/api/user?userId=5
```

```
DELETE http://127.0.0.1:8080/api/user?userId=5
```

```
DELETE http://127.0.0.1:8080/api/users
```

```
POST http://127.0.0.1:8080/api/user
 
Header :
 
 Content-Type : application/json
 
Body :
  
{
  "country": "",
  "name": ""
}
```


```
PUT http://127.0.0.1:8080/api/user?userId=7
  
Header :
 
 Content-Type : application/json
 
body :
  
{
  "country": "",
  "name": ""
}
```