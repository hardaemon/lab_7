package org.example;
import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    String lastName;
    String firstName;
    String patronymic;
    int data;
    int month;
    int year;

    Person () {}

    Person (String lastName, String firstName, String patronymic, int data, int month, int year) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.data = data;
        this.month = month;
        this.year = year;
    }

    public String getLastName() { return lastName; }
    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getData() { return data; }
    public String getPatronymic() { return patronymic; }
    public String getFirstName() { return firstName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return data == person.data && month == person.month && year == person.year && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && Objects.equals(patronymic, person.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymic, data, month, year);
    }
}
