package org.evavdb1.lifesupport;

public class PersonMain {
    public static void main(String[] args) {

        Person jerry = new Person("Jerry", 70, 5000);
        jerry.startLife();

        Person dick = new Person("Dick", 55, 4000);
        Person sally = new Person("Sally", 29, 3000);
        Person harry = new Person("Harry", 31, 2000);
        Person tommy = new Person("Tommy", 14, 1000);

        dick.startLife();
        sally.startLife();
        harry.startLife();
        tommy.startLife();

    }
}
