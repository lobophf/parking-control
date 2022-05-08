package com.api.parkingcontrol.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDto {

  @NotBlank
  @Size(max = 8)
  private String carPlate;

  @NotBlank
  @Size(max = 60)
  private String carOwner;

  @NotBlank
  @Size(max = 10)
  private String carBrand;

  @NotBlank
  @Size(max = 20)
  private String carColor;

  @NotBlank
  @Size(max = 3)
  private String parkingSpotNumber;

  @NotBlank
  @Size(max = 3)
  private String apartmentNumber;

  @NotBlank
  @Size(max = 1)
  private String apartmentBlock;

  public String getCarPlate() {
    return carPlate;
  }

  public void setCarPlate(String carPlate) {
    this.carPlate = carPlate;
  }

  public String getCarOwner() {
    return carOwner;
  }

  public void setCarOwner(String carOwner) {
    this.carOwner = carOwner;
  }

  public String getCarBrand() {
    return carBrand;
  }

  public void setCarBrand(String carBrand) {
    this.carBrand = carBrand;
  }

  public String getCarColor() {
    return carColor;
  }

  public void setCarColor(String carColor) {
    this.carColor = carColor;
  }

  public String getParkingSpotNumber() {
    return parkingSpotNumber;
  }

  public void setParkingSpotNumber(String parkingSpotNumber) {
    this.parkingSpotNumber = parkingSpotNumber;
  }

  public String getApartmentNumber() {
    return apartmentNumber;
  }

  public void setApartmentNumber(String apartmentNumber) {
    this.apartmentNumber = apartmentNumber;
  }

  public String getApartmentBlock() {
    return apartmentBlock;
  }

  public void setApartmentBlock(String apartmentBlock) {
    this.apartmentBlock = apartmentBlock;
  }

}
