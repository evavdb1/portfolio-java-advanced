package org.evavdb1.studentproject;

public class Student extends Person {

    int id;
    private static int incrementId = 0;

    public Student() {    }

    public Student(String name, String lastName) {
        super(name, lastName);
        this.id = getIncrementId();
    }

    private static synchronized int getIncrementId() {
        return ++incrementId;
    }

    @Override
    public String toString() {
        return "ID "+ id +" "+ name +" "+ lastName;
    }
}
