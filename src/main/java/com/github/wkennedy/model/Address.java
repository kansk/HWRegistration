package com.github.wkennedy.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 3691626548025937639L;

    @NotNull
    @Min(1)
    @Max(255)
    private String address1;

    @Max(255)
    private String address2;

    @NotNull
    @Min(1)
    @Max(255)
    private String city;

    @NotNull
    @Min(2)
    @Max(2)
    private String state;

    @NotNull
    @Min(5)
    @Max(9)
    private String zipCode;

    @NotNull
    @Min(3)
    @Max(3)
    private String country;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!address1.equals(address.address1)) return false;
        if (address2 != null ? !address2.equals(address.address2) : address.address2 != null) return false;
        if (!city.equals(address.city)) return false;
        if (!state.equals(address.state)) return false;
        if (!zipCode.equals(address.zipCode)) return false;
        return country.equals(address.country);

    }

    @Override
    public int hashCode() {
        int result = address1.hashCode();
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + zipCode.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
