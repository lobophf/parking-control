This simple REST API handles with condos' park spots. It's an open-source Spring Boot project slightly different from the original one made by Michelli Brito on her course.

To set up and run the server, first access the root project and execute the command below to download the Gradle.
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
curl http://localhost:8080/parking-spot/{id}
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
     http://localhost:8080/parking-spot/{id}
```
DELETE
```sh
curl -X DELETE http://localhost:8080/parking-spot/{id}
```
