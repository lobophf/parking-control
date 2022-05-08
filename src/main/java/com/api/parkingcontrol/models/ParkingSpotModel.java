package com.api.parkingcontrol.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "parkingSpot")
public class ParkingSpotModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(length = 8)
	private String carPlate;

	@NotNull
	@Column(length = 60)
	private String carOwner;

	@NotNull
	@Column(length = 10)
	private String carBrand;

	@NotNull
	@Column(length = 20)
	private String carColor;

	@NotNull
	@Column(length = 3)
	private String parkingSpotNumber;

	@NotNull
	@Column(length = 3)
	private String apartmentNumber;

	@NotNull
	@Column(length = 1)
	private String apartmentBlock;

	@NotNull
	private LocalDateTime registrationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
}
