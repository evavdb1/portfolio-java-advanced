package org.evavdb1.studentproject;

public class ScoreInfoApp {
    public static void main(String[] args) {

        ScoreInfoService list01 = new ScoreInfoService();

        Student stud01 = new Student("Acee", "Orange");
        Student stud02 = new Student("Ben", "Blue");
        Student stud03 = new Student("Roy", "Red");
        Student stud04 = new Student("Ezra", "Pink");
        Student stud05 = new Student("Guy", "Green");

        list01.addScoreInfo(stud01, 80);
        list01.addScoreInfo(stud02, 70);
        list01.addScoreInfo(stud03, 60);
        list01.addScoreInfo(stud04, 49);
        list01.addScoreInfo(stud05, 95);
        /*
        System.out.println(stud01);
        System.out.println(stud02);
        System.out.println(stud03);
        System.out.println(stud04);
        System.out.println(stud05);
        */
        System.out.print("\nthe number of students is: ");
        System.out.println(list01.getNumberOfStudents());

        System.out.print("\nthe average score is: ");
        list01.calculateAverageScore();

        System.out.print("\nthe number of Honor Students is: ");
        System.out.println(list01.filterScore());

        System.out.println("\nThe students who failed are: ");
        list01.printFailingStudents();

        System.out.println("\nstudents (alphabetically): ");
        list01.getDataSortedByLastName();

        System.out.println("\nhonor roll: ");
        list01.getDataSortedByScore();
    }
}
