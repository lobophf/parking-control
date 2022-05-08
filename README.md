# Parking Control

This simple REST API handles condos' park spots. It's an open-source Spring Boot project slightly different from the original one made by [@Michelli Brito](https://github.com/MichelliBrito) on her [course](https://www.youtube.com/watch?v=LXRU-Z36GEU).

To set up and run the server, you need to create a MySQL database and add a file `/src/main/resources/application.properties` which the following content. Don't forget to replace fields like database name, username, and password.

```
spring.jpa.hibernate.ddl-auto=update    
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/{database name}
spring.datasource.username={user name}    
spring.datasource.password={user password}    
spring.datasource.driver-class-name =com.mysql.jdbc.Driver    
```
Now, go to the root project and run the command below to download a specific version of Gradle locally.
```sh 
gradle wrapper
```
Then, run this Gradle task:
```sh
./gradlew bootRun
```
## REST API Methods
You might want to access the endpoints using the following cURL commands.

GET
```sh
curl http://localhost:8080/parking-spot
curl http://localhost:8080/parking-spot/{id}
```
POST
```sh
curl -X POST -H "Content-Type: application/json" \
    -d '{
	 "carPlate": "SXD-7621",
	 "carOwner": "Taffarel",
	 "carColor": "Black",
	 "carBrand": "BMW",
	 "apartmentNumber": "23",
	 "apartmentBlock": "1",
	 "parkingSpotNumber": 2
	}' \
     http://localhost:8080/parking-spot
```
UPDATE
```sh
curl -X PUT -H "Content-Type: application/json" \
    -d '{
	 "carPlate": "SXD-7621",
	 "carOwner": "Taffarel",
	 "carColor": "Black",
	 "carBrand": "BMW",
	 "apartmentNumber": "23",
	 "apartmentBlock": "1",
	 "parkingSpotNumber": 2
	}' \
http://localhost:8080/parking-spot/{id}
```
DELETE
```sh
curl -X DELETE http://localhost:8080/parking-spot/{id}
```
