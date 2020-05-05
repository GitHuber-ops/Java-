package com.company;

import java.io.*;

import static com.company.IOModule.*;
import static com.company.PrintModule.print;
import static com.company.SortModule.*;

public class AcademicTeacher {
    String number;
    String name;
    String academy;
    File outputFile = new File("D://academicTeacherOutput.txt");
    static File inputFile = new File("D://academicTeacherInput.txt");

    AcademicTeacher(String number, String name, String academy){
        this.number = number;
        this.name = name;
        this.academy = academy;
    }

    @Override
    public String toString(){
        return String.format("academic teacher number: %s\n" +
                        "name: %s\n" + "academy: %s\n"
                , number, name, academy);
    }

    //Using multi output stream to make operate easily as soon as fast.
    public void save(){
        try(BufferedWriter output = new BufferedWriter(new FileWriter(outputFile, true))){
            output.write(number);
            output.write(name);
            output.write(academy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() throws EOFException {
        AcademicTeacher teacher = null;
        try(BufferedReader input = new BufferedReader(new FileReader(inputFile))) {
            String teacherInformation = null;
            while ((teacherInformation = input.readLine()) != null) {
                String[] splited = teacherInformation.split(" ");
                teacher = new AcademicTeacher(splited[0], splited[1], splited[2]);
                academicTeacherList.add(teacher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Need to be finished...
    public void teacherInquire(String number) {
        Student student =
                com.company.Search.studentSearch(number);
        Score[] score =
                com.company.Search.studentScoreSearch(student.name);
        Course[] course =
                student.studentCourse;
        if(student != null){
            //com.company.PrintModule.print(teacherCourse);
            com.company.PrintModule.print(score);
        }
    }

    public void setAcademicTeacher(String number, String name, String academy){
        this.number = number;
        this.name = name;
        this.academy = academy;
    }

    public static void courseManagement(){

    }


    public static void rank(){
        sort(scoreList);
        print(scoreList);
    }
}
