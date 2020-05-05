//Need to be finished...
package com.company;

import java.util.Arrays;
import static com.company.IOModule.*;

public class Search {
    public static Student studentSearch(String number){
        for(Student student : studentList){
            if(student.number.equals(number)){
                return student;
            }
        }
        System.out.println("No student's number matched...");
        return null;
    }

    public static Teacher teacherSearch(String number){
        for(Teacher teacher : teacherList){
            if(teacher.number.equals(number)){
                return teacher;
            }
        }
        System.out.println("No teacher's number matched...");
        return null;
    }

    public static AcademicTeacher academicTeacherSearch(String number){
        for(AcademicTeacher teacher : academicTeacherList){
            if(teacher.number.equals(number)){
                return teacher;
            }
        }
        System.out.println("No teacher's number matched...");
        return null;
    }

    //Need to be finished...
    public static Score[] studentScoreSearch(String studentName){
        Score[] scores = new Score[5];
        int scoreNumber = 0;
        for(Score score : scoreList){
            if(scores.length == scoreNumber){
                scores = Arrays.copyOf(scores, scores.length*2);
            }
            if(score.studentName.equals(studentName)){
                scores[scoreNumber] = score;
                scoreNumber++;
            }
        }
        if(scoreNumber == 0) {
            System.out.println("You do not have any scores.");
            return null;        //Don't show anything when score is null.
        }
        System.out.println("Here are you scores information: ");

        for(Score score : scores) {
            if (score != null) {
                System.out.println(score);
            }
        }
            return scores;
    }

    public static Score[] teacherScoreSearch(String teacherName){
        Score[] scores = new Score[5];
        int scoreNumber = 0;
        for(Score score : scoreList){
            if(scores.length == scoreNumber){
                scores = Arrays.copyOf(scores, scores.length*2);
            }
            if(score.teacherName.equals(teacherName)){
                scores[scoreNumber] = score;
                scoreNumber++;
            }
        }

        //Print only when student has scores.
        if(scoreNumber == 0) {
            System.out.println("You do not have any scores.");
            return null;        //Don't show anything when score is null.
        }
        System.out.println("Here are you scores information: ");


        for(Score score : scores) {
            if (score != null) {
                System.out.println(score);
            }
        }
        return scores;
    }

}
