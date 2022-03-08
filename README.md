gradle wrapper
gradew bootRun

curl http://localhost:8080/parking-spot -s | json_pp

curl http://localhost:8080/parking-spot/70dbacc4-d14c-4537-b1be-4867848b628b -s | json_pp

POST
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

GET
curl http://localhost:8080/parking-spot

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
     http://localhost:8080/parking-spot/70dbacc4-d14c-4537-b1be-4867848b628b
