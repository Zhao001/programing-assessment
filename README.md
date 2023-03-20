# integration-demo

```
Flow:
UI[Index.html] -> GateWay[Nignx] -> Rest Sercie[Camel + SpringBoot] -> DataBase[Mongo]

```

Project name: https://github.com/Zhao001/integration-demo

## Modules list
| Name           | project folder or file     | description                                                                                                                                                                                         |
|----------------|----------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| service        | camel-service              | mvn 3.6.3, jdk11  <br/> publish restful API by use Camel + spring boot                                                                                                                              | 
| docker compose | docker-compose-integration | deploy Nignx + Integration service + MongoDB. <br/>Nignx: https://localhost -> http://localhost:8080 ; http://localhost -> https://locahost  <br/>MongoDB port: 27017  <br/>rest service port: 8080 | 
| UI             | Index.html                 | insert data and list all data by UI                                                                                                                                                                 |



## Modules Introduce

### Service
Implement Rest APIs that based on Camel Springboot, it will publish paths  /api/users/addUser and /api/users to insert/list all User data.  
User date will be stored in Mongo database. 

Actions:  

- insert User:
```
curl -d '{"name":"John A", "tel":"123-12345", "age": 11 }' -H "Content-Type: application/json" -X POST https://localhost/api/users/addUser -k
```
- find all users:
```
Use IE to access URL: 
https://localhost/api/users
```

Refer to:  
https://github.com/apache/camel-spring-boot-examples/tree/main/rest-openapi
https://github.com/apache/camel-spring-boot-examples/tree/main/platform-http

### MongoDB
There is a Collection which named user in this Database, it will be deployed by docker-compose up.  

### docker compose
docker-compose-integration/docker-compose.yml
docker compose contains 3 services: mongo/integration/nginx
after all servers started by command docker-compose up -d, we could HTML file  
Index.html to insert and search data.

### UI
HTML file Index.html
open Indx.html, then  
click button Submit to insert data,   
click button "Get User" to list all users info.

## Integration build and deploy:
- go to folder camel-service/rest-openapi, run build Command: mvn clean install
- copy service jar file into docker-compose folder: 
```
cp -rf ./camel-service/rest-openapi/target/camel-demo-service-3.16.0.jar docker-compose-integration/integration/camel-demo-service-3.16.0.jar
```
- go to ./docker-compose-integration
- startup command: docker-compose up -d
- open Index.html by IE, use it to insert and search data.

## project progress
- [x] Three services have completed
- [x] Docker images
- [x] Docker compose design and publish services successful
- [x] UI : use HTML file Index.html to add/list data.
- [ ] Testing
- [x] Ansible scripts


