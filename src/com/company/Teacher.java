package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static com.company.IOModule.teacherList;

public class Teacher {
    String number;
    String name;
    String academy;
    String major;
    Course[] courses = new Course[5]; //Default length of score array is 5.
    int courseNumber = 0;

    File outputFile = new File("D://teacherOutput.txt");
    static File inputFile = new File("D://teacherInput.txt");

    Teacher(String number, String name, String academy, String major){
        this.number = number;
        this.name = name;
        this.academy = academy;
        this.major = major;
    }

    void setTeacher(String number, String name, String academy, String major){
        this.number = number;
        this.name = name;
        this.academy = academy;
        this.major = major;
    }


    @Override
    public String toString(){
        return String.format("teacher number: %s\n" +
                        "name: %s\n" + "academy: %s\n" + "major: %s\n"
                , number, name, academy, major);
    }

    //Using multi output stream to make operate easily as soon as fast.
    public void save(){
        try(BufferedWriter output = new BufferedWriter(new FileWriter(outputFile, true))){
            output.write(number);
            output.write(name);
            output.write(academy);
            output.write(major);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() throws EOFException {
        Teacher teacher = null;
        try(BufferedReader input = new BufferedReader(new FileReader(inputFile))) {
            String teacherInformation = null;
            while ((teacherInformation = input.readLine()) != null) {
                String[] splited = teacherInformation.split(" ");
                teacher = new Teacher(splited[0], splited[1], splited[2], splited[3]);
                teacherList.add(teacher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Need to be finished...
    public void teacherInquire(){
        if(courses[0] == null)
            System.out.println("You didn't have any course yet...\n");
        else
            System.out.println("Here are your courses information: ");
        com.company.PrintModule.print(courses);
    }

    public void addCourse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input course's number, name, credit and period.");
        Course course = new Course(scanner.next(), scanner.next(), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
        //If there is no more space for adding a new course, double the length of studentCourse.
        if(courses.length == this.courseNumber){
            courses = Arrays.copyOf(courses, courses.length*2);
        }
        courses[courseNumber] =  course;
        courseNumber++;
        System.out.println("Add successfully.\n");
    }
}
