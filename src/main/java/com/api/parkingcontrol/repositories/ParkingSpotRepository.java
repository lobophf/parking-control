package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;

import org.springframework.data.repository.CrudRepository;

public interface ParkingSpotRepository extends CrudRepository<ParkingSpotModel, Long> {

  public boolean existsByCarPlate(String carPlate);

  public boolean existsByParkingSpotNumber(String parkingSpotNumber);

  public boolean existsByApartmentNumber(String apartmentNumber);

  public boolean existsByApartmentBlock(String apartmentBlock);

}
