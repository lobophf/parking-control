package com.api.parkingcontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking-spot")
public class ParkingSpotController {

  @Autowired
  private ParkingSpotService parkingSpotService;

  @PostMapping
  public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {

    if (parkingSpotService.existsByCarPlate(parkingSpotDto.getCarPlate())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: The car is already parked.");
    }

    if (parkingSpotService.existsBySpotNumber(parkingSpotDto.getParkingSpotNumber())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: The parking spot is already in use.");
    }

    if (parkingSpotService.existsByApartmentNumberAndApartmentBlock(parkingSpotDto.getApartmentNumber(),
        parkingSpotDto.getApartmentBlock())) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body("Conflict: Parking Spot already resgistered for this apartment/ block.");
    }

    ParkingSpotModel parkingSpotModel = new ParkingSpotModel();

    BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
    parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.add(parkingSpotModel));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> replace(@RequestBody @Valid ParkingSpotDto parkingSpotDto,
      @PathVariable(value = "id") Long id) {

    if (parkingSpotService.existsByCarPlate(parkingSpotDto.getCarPlate())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: The car is already parked.");
    }

    if (parkingSpotService.existsBySpotNumber(parkingSpotDto.getParkingSpotNumber())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: The parking spot is already in use.");
    }

    if (parkingSpotService.existsByApartmentNumberAndApartmentBlock(parkingSpotDto.getApartmentNumber(),
        parkingSpotDto.getApartmentBlock())) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body("Conflict: Parking Spot already resgistered for this apartment/ block.");
    }

    ParkingSpotModel parkingSpotModel = new ParkingSpotModel();

    BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
    parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.update(parkingSpotModel, id));
  }

  @GetMapping
  public ResponseEntity<Object> getAll() {
    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.getAll());
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Object> getById(@PathVariable(value = "id") long id) {
    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.getById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> remove(@PathVariable(value = "id") long id) {

    if (!parkingSpotService.existsParkingSpotById(id)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking spot not found.");
    }

    parkingSpotService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("The quotation was seccesfully deleted.");
  }
}
