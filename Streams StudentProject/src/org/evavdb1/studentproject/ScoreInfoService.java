package org.evavdb1.studentproject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ScoreInfoService {

    private ScoreInfo[] scoreData;
    long numberOfStudents = 0;

    private List<ScoreInfo> scoreList = new ArrayList<>();

    public ScoreInfoService() {    }

    public void addScoreInfo(Student student, int score) {
        scoreList.add(new ScoreInfo(student, score));
        numberOfStudents++;
    }

    public long getNumberOfStudents() {
        //return scoreList.stream().count();
        return numberOfStudents;
    }

    public void calculateAverageScore() {
        double avg = scoreList.stream()
                .mapToInt(ScoreInfo::getScore)
                .average()
                .orElse(0);
        System.out.println(avg);
    }

    public long filterScore() {
        return scoreList.stream()
                .filter(str01 -> str01.getScore() >= 90)
                .count();
    }

    private String[] getFailedStudents() {
        return scoreList.stream()
                .filter(str02 -> str02.getScore() < 60)
                .map(ScoreInfo::toString)
                .toArray(String[]::new);
    }

    public void printFailingStudents() {
        Arrays.stream(getFailedStudents())
                .forEach(fail -> System.out.println(fail.toString()));
    }

    public void getDataSortedByLastName() {
        scoreList.stream()
                .sorted(Comparator.comparing(str03 -> str03.getStudent().lastName))
                .forEach(name -> System.out.println(name.getStudent()));
    }

    public void getDataSortedByScore() {
        scoreList.stream()
                .sorted(Comparator.comparingInt(ScoreInfo::getScore).reversed())
                .forEach(score -> System.out.println(score.getStudent()));
    }
}
