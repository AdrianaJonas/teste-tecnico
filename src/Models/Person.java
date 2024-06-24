package Models;

import java.time.LocalDate;

public class Person implements Comparable<Person> {
    private String name;
    private LocalDate dateOfBirth;

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return this.getName().compareTo(otherPerson.getName());
    }
}
