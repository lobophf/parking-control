package com.api.parkingcontrol.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.api.parkingcontrol.exception.SpotNotFoundException;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

  @Autowired
  private ParkingSpotRepository parkingSpotRepository;

  @Transactional
  public ParkingSpotModel add(ParkingSpotModel parkingSpotModel) {
    return parkingSpotRepository.save(parkingSpotModel);
  }

  public Optional<Object> update(ParkingSpotModel parkingSpotModel, Long id) {

    return parkingSpotRepository.findById(id).map(record -> {
      record.setCarPlate(parkingSpotModel.getCarPlate());
      record.setCarOwner(parkingSpotModel.getCarOwner());
      record.setCarBrand(parkingSpotModel.getCarBrand());
      record.setCarColor(parkingSpotModel.getCarColor());
      record.setParkingSpotNumber(parkingSpotModel.getParkingSpotNumber());
      record.setApartmentNumber(parkingSpotModel.getApartmentNumber());
      record.setApartmentBlock(parkingSpotModel.getApartmentBlock());
      return parkingSpotRepository.save(record);
    });
  }

  public Object getAll() {
    return parkingSpotRepository.findAll();
  }

  public void delete(long id) {
    this.existsParkingSpotById(id);
    parkingSpotRepository.deleteById(id);
  }

  public boolean existsParkingSpotById(long id) {
    if (parkingSpotRepository.existsById(id)) {
      return true;
    } else {
      throw new SpotNotFoundException(id);
    }
  }

  public boolean existsByCarPlate(String carPlate) {
    return parkingSpotRepository.existsByCarPlate(carPlate);
  }

  public boolean existsBySpotNumber(String parkingSpotNumber) {
    return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
  }

  public boolean existsByApartmentNumberAndApartmentBlock(String apartmentNumber, String apartmentBlock) {
    return parkingSpotRepository.existsByApartmentNumber(apartmentNumber)
        && parkingSpotRepository.existsByApartmentBlock(apartmentBlock);
  }

  public Object getById(Long id) {
    return parkingSpotRepository.findById(id);
  }
}
