# integration-demo

```
graph TB 
 White-Project-UAT-Nightly-Build-->White-Project-UAT-Nightly-CopyArchive  
```

Project name: https://github.com/Zhao001/integration-demo

## Module list
| Name           | project folder             | description                                                                                                                                                                                         |
|----------------|----------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| integration    | camel-spring-boot-examples | mvn 3.6.3, jdk11  <br/> publish restful API by use Camel + spring boot                                                                                                                              | 
| docker compose | docker-compose-integration | deploy Nignx + Integration service + MongoDB. <br/>Nignx: https://localhost -> http://localhost:8080 ; http://localhost -> https://locahost  <br/>MongoDB port: 27017  <br/>rest service port: 8080 | 
| UI             | Index.html                 | insert data and list all data by UI                                                                                                                                                                 |

## Integration build and deploy:
- go to integration-demo\docker-compose-integration,  build Command: mvn clean install 
- copy service jar file into docker-compose folder: copy ./camel-spring-boot-examples/target/camel-example-spring-boot-rest-openapi-3.16.0.jar ./docker-compose-integration/integration/target/camel-example-spring-boot-rest-openapi-3.16.0.jar
- go to ./docker-compose-integration
- startup command: docker-compose up -d

## Testing URLs

find all users:
```
https://royzhao/api/users
```
insert User:
```
curl -d '{"name":"John A", "tel":"1111111", "age": 11 }' -H "Content-Type: application/json" -X POST https://royzhao/api/users/addUser -k
```


## project progress
- [x] Three services have completed
- [x] Docker images
- [x] Docker compose design and publish services successful
- [x] UI : use HTML file Index.html to add/list data.
- [ ] Testing
- [x] Ansible scripts


