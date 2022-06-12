package com.api.parkingcontrol.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * With the intention to reduce excessive code and help, you can opt to use Lombok annotations.
 * It will generate the correspondent getters and setter for each member variable declared in the class.
 * You can read more about lombok on their website: https://projectlombok.org/features/all
 */
@Entity
@Table(name = "parkingSpot")
@Getter
@Setter
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
}
