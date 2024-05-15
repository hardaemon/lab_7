package org.example;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class House implements Serializable {
    String number;
    String address;
    Person mainPerson;
    List<Flat> flats;

    House () {}

    House (String number, String address, Person main, List<Flat> flats) {
        this.number = number;
        this.address = address;
        this.mainPerson = main;
        this.flats = flats;
    }

    public String getNumber() { return number; }
    public String getAddress() { return address; }
    public Person getMainPerson() { return mainPerson; }
    public List<Flat> getFlats() { return flats; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House house)) return false;
        return Objects.equals(number, house.number) && Objects.equals(address, house.address) && Objects.equals(mainPerson, house.mainPerson) && Objects.equals(flats, house.flats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, address, mainPerson, flats);
    }
}
