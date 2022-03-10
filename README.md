This simple REST API handles with condos' park spots. It's an open-source Spring Boot project slightly different from the original one made by [@Michelli Brito](https://github.com/MichelliBrito) on her [course](https://www.youtube.com/watch?v=LXRU-Z36GEU).

To set up and run the server, you need to create a Postgres database and add a file `/src/main/resources/application.properties` which the following content. Don't forget to replace the fields with the database name, user, and password.

```
spring.datasource.url= jdbc:postgresql://localhost:5432/{database_name}
spring.datasource.username={username}
spring.datasource.password={password}
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

Now, access the root project and execute the command below to download the Gradle locally.
```sh 
gradle wrapper
```
Then, run this Gradle task:
```sh
./gradlew bootRun
```

GET
```sh
curl http://localhost:8080/parking-spot
curl http://localhost:8080/parking-spot/{UUID}
```
POST
```sh
curl -X POST -H "Content-Type: application/json" \
    -d '{
	 "parkingSpotNumber": "285B",
	 "licensePlateCar": "RRS9870",
	 "brandCar": "Audi",
	 "modelCar": "q5",
	 "colorCar": "black",
	 "responsibleName": "Taffarel",
	 "apartment": "001",
	 "block": "B"
	}' \
     http://localhost:8080/parking-spot
```
UPDATE
```sh
curl -X PUT -H "Content-Type: application/json" \
    -d '{
	 "parkingSpotNumber": "285B",
	 "licensePlateCar": "UUX1229",
	 "brandCar": "BMW",
	 "modelCar": "XL",
	 "colorCar": "White",
	 "responsibleName": "Tardelli",
	 "apartment": "001",
	 "block": "A"
	}' \
     http://localhost:8080/parking-spot/{UUID}
```
DELETE
```sh
curl -X DELETE http://localhost:8080/parking-spot/{UUID}
```
