package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/*
 * [public] access modifier keyword is redundant in interfaces. You don't need to declare them explicit.
 * As JSL (Java Language Specification) for java 11 (https://docs.oracle.com/javase/specs/jls/se11/html/jls-9.html#jls-9.4)
 * specifies:
 * "A method in the body of an interface may be declared public or private (§6.6).
 * If no access modifier is given, the method is implicitly public.
 * It is permitted, but discouraged as a matter of style,
 * to redundantly specify the public modifier for a method declaration in an interface."
 *
 * Also, I would suggest to use JpaRepository over the CrudRepository.
 * This is because JpaRepository returns List instead of Iterators.
 * This makes easier to make operations when dealing with methods that returns a collection of objects.
 * JpaRepository extends indirectly from CrudRepository, so all of its functionality is included.
 * https://stackoverflow.com/a/14025100
 */
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, Long> {

  boolean existsByCarPlate(String carPlate);

  boolean existsByParkingSpotNumber(String parkingSpotNumber);

  boolean existsByApartmentNumber(String apartmentNumber);

  boolean existsByApartmentBlock(String apartmentBlock);

}
