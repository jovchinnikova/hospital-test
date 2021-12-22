package com.solvd.hospitaltest.domain;

import java.util.Objects;

public class Address {

    private Long id;
    private String city;
    private String street;
    private String buildingNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return city.equals(address.city) && street.equals(address.street)
                && buildingNumber.equals(address.buildingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, buildingNumber);
    }
}
