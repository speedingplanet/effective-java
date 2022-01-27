package org.efjava.demos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LombokHamcrest {
//  Just a POJO for testing purposes
  private final String name;
  private final LocalDate birthDate;
  private final int favoriteNumber;

}
