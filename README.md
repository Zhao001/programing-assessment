# Assessment: integration-demo

```
Design Flow:
UI[Index.html] -> GateWay[Nignx] -> Restful Service[Camel + SpringBoot] -> DataBase[Mongo]

```

Git Project URL: https://github.com/Zhao001/programing-assessment   

**There is a video file ./video-deploy-steps.mp4, which will share deployment steps one by one.**

**Quickly Testing steps:**
- download source code from  https://github.com/Zhao001/programing-assessment  by Git , goto docker compose folder ./docker-compose-integration  
run command:
```
cd ./docker-compose-integration  
docker-compose up -d
```
- after all services started successful,  open ./Index.html by IE, then could insert and list data.

## Modules list
| Name           | Project folder or file     | Description                                                                                                                                                                                                  |
|----------------|----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| service        | camel-service              | mvn 3.6.3, jdk11  <br/> publish Restful API by Camel and spring boot                                                                                                                                         | 
| docker compose | docker-compose-integration | deploy services Nignx + Integration service + MongoDB. <br/>Nignx: https://localhost -> http://localhost:8080 ; http://localhost -> https://locahost  <br/>MongoDB port: 27017  <br/>rest service port: 8080 | 
| UI             | Index.html                 | insert and list all data by UI                                                                                                                                                                               |



## Modules Introduce

### Service
Implement Rest API that based on Camel Springboot, it will publish services by paths /api/users/addUser and /api/users.  
User data could be stored in Mongo database. 

Test Actions:  

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
Database have a Collection which named user;  
DB server will be deployed in docker-compose up.  

### docker compose
file: docker-compose-integration/docker-compose.yml  
Docker compose contains 3 services: mongo/integration/nginx, 
after all servers started by command "docker-compose up -d", we could open HTML file  
Index.html to insert and list data.

### UI
HTML file: Index.html
open Index.html by IE, then  
click button "Submit" to insert data,   
click button "Get User" to list all user info.

## Integration build and deploy:
- go to folder camel-service/rest-openapi, run build Command: mvn clean install
- copy service jar file into docker-compose folder: 
```
cp -rf ./camel-service/rest-openapi/target/camel-demo-service-3.16.0.jar docker-compose-integration/integration/camel-demo-service-3.16.0.jar
```
- go to ./docker-compose-integration
- startup command: docker-compose up -d
- after all services started successful, open Index.html by IE to test continue.

## project progress
- [x] Three services have completed
- [x] Docker images
- [x] Docker compose design and publish services successful
- [x] UI : use HTML file Index.html to add/list data.
- [ ] Testing
- [x] Ansible scripts


