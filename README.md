# Kubity Test Project

## Launch App

By default the port is expose on the port 8080. The port can ba change by modified the file application.properties

```
mvn spring-boot:run
```

### Use Api

You can use a client rest or go to this url : [Swagger](http://127.0.0.1:8080/swagger-ui.html)

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