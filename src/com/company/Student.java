package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static com.company.IOModule.studentList;

public class Student implements Comparable{
    String number;
    String name;
    String sex;
    String birthday;
    String academy;
    String major;
    Course[] studentCourse = new Course[5];   //The default length of course Array is 5.
    int courseNumber = 0;                     //Record/Point to the current course.

    File outputFile = new File("D://studentOutput.txt");
    static File inputFile = new File("D://studentInput.txt");

    Student(String number, String name, String sex, String birthday, String academy, String major){
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.academy = academy;
        this.major = major;
    }


    @Override
    public String toString(){
        return String.format("student number: %s\n" + "name: %s\n" + "sex: %s\n" + "birthday: %s\n" + "academy: %s\n" +"major: %s\n"
                , number, name, sex, birthday, academy, major);
    }

    @Override
    public int compareTo(Object o) {
        return this.compareTo(((Student) o).number);
    }

    //Using multi output stream to make operate easily as soon as fast.
    public void save(){
        try(BufferedWriter output = new BufferedWriter(new FileWriter(outputFile, true))){
            output.write(number);
            output.write(name);
            output.write(sex);
            output.write(birthday);
            output.write(academy);
            output.write(major);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() throws EOFException{
        Student student = null;
        try(BufferedReader input = new BufferedReader(new FileReader(inputFile))) {
            String studentInformation = null;
                while ((studentInformation = input.readLine()) != null) {
                    String[] splited = studentInformation.split(" ");
                    student = new Student(splited[0], splited[1], splited[2], splited[3], splited[4], splited[5]);
                    studentList.add(student);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Personal information maintenance
    void setStudent(String number, String name, String sex, String birthday, String academy, String major){
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.academy = academy;
        this.major = major;
    }

    public void studentInquire(){
            if(studentCourse[0] == null)
                System.out.println("You didn't have any course yet...\n");
            else
                System.out.println("Here are your courses information: ");
            com.company.PrintModule.print(studentCourse);
    }

    public void addCourse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input course's number, name, credit and period.");
        Course course = new Course(scanner.next(), scanner.next(), Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next()));
        //If there is no more space for adding a new course, double the length of studentCourse.
        if(studentCourse.length == this.courseNumber){
            studentCourse = Arrays.copyOf(studentCourse, studentCourse.length*2);
        }
        studentCourse[courseNumber] =  course;
        courseNumber++;
        System.out.println("Add successfully.\n");
    }
}
