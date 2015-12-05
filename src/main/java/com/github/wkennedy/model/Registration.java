package com.github.wkennedy.model;

import java.io.Serializable;

public class Registration implements Serializable {

    private static final long serialVersionUID = -5449897264140389867L;

    private Person person;
    private Address address;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registration that = (Registration) o;

        if (!person.equals(that.person)) return false;
        return address.equals(that.address);

    }

    @Override
    public int hashCode() {
        int result = person.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "person=" + person +
                ", address=" + address +
                '}';
    }
}
