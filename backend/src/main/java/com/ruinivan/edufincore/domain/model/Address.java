package com.ruinivan.edufincore.domain.model;

import java.util.UUID;

public class Address extends Base {
  private UUID studentId;
  private String zipCode;
  private String street;
  private String number;
  private String complement;
  private String district;
  private String city;
  private String state;
  private boolean mainAddress;

  public Address(UUID studentId, String zipCode, String street, String number, String complement, String district,
      String city, String state, boolean mainAddress) {
    this.studentId = studentId;
    this.zipCode = zipCode;
    this.street = street;
    this.number = number;
    this.complement = complement;
    this.district = district;
    this.city = city;
    this.state = state;
    this.mainAddress = mainAddress;
  }

  public UUID getStudentId() {
    return this.studentId;
  }

  public String getZipCode() {
    return this.zipCode;
  }

  public String getStreet() {
    return this.street;
  }

  public String getNumber() {
    return this.number;
  }

  public String getComplement() {
    return this.complement;
  }

  public String getDistrict() {
    return this.district;
  }

  public String getCity() {
    return this.city;
  }

  public String getState() {
    return this.state;
  }

  public boolean isMainAddress() {
    return this.mainAddress;
  }
}
