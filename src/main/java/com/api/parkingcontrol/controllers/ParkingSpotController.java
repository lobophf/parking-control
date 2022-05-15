package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.exception.ValidationConflictException;
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

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/parking-spot")
public class ParkingSpotController {

  @Autowired
  private ParkingSpotService parkingSpotService;


  /*
   * Here we can find some duplicated code (lines 38-55 and 64-81) that can be refactored to be reusable.
   *
   * Observe that for each validation, the same HttpStatus code is being returned, changing only the body information.
   * You could opt here to create a new method that will be responsible to do these verifications, and then throw an exception.
   * This would allow you to treat this exception in the CustomExceptionHandler, also permitting the reuse of these functions.
   */

  @PostMapping
  public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
    this.validateParkingSpotInformation(parkingSpotDto);

    ParkingSpotModel parkingSpotModel = new ParkingSpotModel();

    BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
    parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

    return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.add(parkingSpotModel));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> replace(@RequestBody @Valid ParkingSpotDto parkingSpotDto,
      @PathVariable(value = "id") Long id) {

    this.validateParkingSpotInformation(parkingSpotDto);

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
  public ResponseEntity remove(@PathVariable(value = "id") long id) {
    parkingSpotService.delete(id);
    return ResponseEntity.noContent().build();
  }

  private void validateParkingSpotInformation(ParkingSpotDto parkingSpotDto) {
    if (parkingSpotService.existsByCarPlate(parkingSpotDto.getCarPlate())) {
      throw new ValidationConflictException("Conflict: The car is already parked.");
    }

    if (parkingSpotService.existsBySpotNumber(parkingSpotDto.getParkingSpotNumber())) {
      throw new ValidationConflictException("Conflict: The parking spot is already in use.");
    }

    if (parkingSpotService.existsByApartmentNumberAndApartmentBlock(parkingSpotDto.getApartmentNumber(),
            parkingSpotDto.getApartmentBlock())) {
      throw new ValidationConflictException("Conflict: The parking Spot is already resgistered for this apartment/ block.");
    }
  }

}
