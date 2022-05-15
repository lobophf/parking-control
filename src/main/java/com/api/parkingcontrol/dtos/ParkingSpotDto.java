package com.api.parkingcontrol.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
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

}
