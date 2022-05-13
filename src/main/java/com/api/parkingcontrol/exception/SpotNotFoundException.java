package com.api.parkingcontrol.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SpotNotFoundException extends RuntimeException {

  public SpotNotFoundException(Long id) {
    super(String.format("Parking spot with id %s was not found", id));
  }

}
