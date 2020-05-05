package com.company;

import java.io.*;

import static com.company.IOModule.scoreList;
import static com.company.IOModule.studentList;

public class Score implements Comparable{
    String number;
    String name;
    String teacherName;
    String studentName;
    int score;
    File outputFile = new File("D://scoreOutput.txt");
    static File inputFile = new File("D://scoreInput.txt");

    Score(String number, String name, String teacherName, String studentName, int score){
        this.number = number;
        this.name = name;
        this.teacherName = teacherName;
        this.studentName = studentName;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        return this.score - ((Score)o).score;
    }

    @Override
    public String toString(){
        return String.format("score number: %s\n" +
                "score name: %s\n" + "teacher's name: %s\n" + "student's name: %s\n" + "score: %d\n"
                , number, name, teacherName, studentName, score);
    }

    //Using multi output stream to make operate easily as soon as fast.
    public void save(){
        try(BufferedWriter output = new BufferedWriter(new FileWriter(outputFile, true))){
            output.write(number);
            output.write(name);
            output.write(teacherName);
            output.write(studentName);
            output.write(score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() throws EOFException {
        Score score = null;
        try(BufferedReader input = new BufferedReader(new FileReader(inputFile))) {
            String scoreInformation = null;
            while ((scoreInformation = input.readLine()) != null) {
                String[] splited = scoreInformation.split(" ");
                score = new Score(splited[0], splited[1], splited[2], splited[3], Integer.parseInt(splited[4]));
                scoreList.add(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
