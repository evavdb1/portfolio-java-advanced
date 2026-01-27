package org.evavdb1.studentproject;

public abstract class Person {

    String name;
    String lastName;

    public Person() {    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }
}
