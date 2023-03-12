package ru.netology.entity;

public class Location {

  private final String city;

  private final Country country;

  private final String street;

  private final int builing;

  public Location(String city, Country country, String street, int builing) {
    this.city = city;
    this.country = country;
    this.street = street;
    this.builing = builing;
  }

  public String getCity() {
    return city;
  }

  public Country getCountry() {
    return country;
  }

  public String getStreet() {
    return street;
  }

  public int getBuiling() {
    return builing;
  }

  @Override
  public int hashCode() {
    return city.hashCode() + country.hashCode() + street.hashCode() + builing;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    }
    if (!(object instanceof Location objStudent)) {
      return false;
    }
    boolean countryEquals = false;
    if (country == null) {
      if (objStudent.country == null) {
        countryEquals = true;
      }
    } else {
      countryEquals = country.equals(objStudent.country);
    }
    boolean cityEquals = false;
    if (city == null) {
      if (objStudent.city == null) {
        cityEquals = true;
      }
    } else {
      cityEquals = city.equals(objStudent.city);
    }
    boolean streetEquals = false;
    if (street == null) {
      if (objStudent.street == null) {
        streetEquals = true;
      }
    } else {
      streetEquals = street.equals(objStudent.street);
    }
    return countryEquals && cityEquals && streetEquals && builing == objStudent.builing;
  }
}
