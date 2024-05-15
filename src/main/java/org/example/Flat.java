package org.example;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Flat implements Serializable {
    int number;
    int area;
    List<Person> persons;

    Flat () {}

    Flat (int number, int area, List<Person> persons) {
        this.number = number;
        this.area = area;
        this.persons = persons;
    }

    public int getNumber() { return number; }
    public int getArea() { return area; }
    public List<Person> getPersons() { return persons; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat flat)) return false;
        return number == flat.number && area == flat.area && Objects.equals(persons, flat.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, area, persons);
    }
}
