package org.evavdb1.studentproject;

public class ScoreInfo {

    int score;
    Student student;

    public ScoreInfo(Student student, int score) {
        this.student = student;
        this.score = score;
    }

    public int getScore() {        return score;    }
    public Student getStudent() {        return student;    }

    @Override
    public String toString() {
        return student + ", score " + score;
    }
}
