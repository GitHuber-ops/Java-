package com.company;

import java.io.*;

import static com.company.IOModule.courseList;

public class Course {
    String number;
    String name;
    int credit;
    int period;
    File outputFile = new File("D://courseOutput.txt");
    static File inputFile = new File("D://courseInput.txt");

    Course(String number, String name, int credit, int period){
        this.number = number;
        this.name = name;
        this.credit = credit;
        this.period = period;
    }

    @Override
    public String toString(){
        return String.format("course number: %s\n" + "name: %s\n" + "credit: %d\n" + "period: %d\n"
                , number, name, credit, period);
    }

    public void save(){
        try(BufferedWriter output = new BufferedWriter(new FileWriter(outputFile, true))){
            output.write(number);
            output.write(name);
            output.write(credit);
            output.write(period);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() throws EOFException {
        Course course = null;
        try(BufferedReader input = new BufferedReader(new FileReader(inputFile))) {
            String courseInformation = null;
            while ((courseInformation = input.readLine()) != null) {
                String[] splited = courseInformation.split(" ");
                course = new Course(splited[0], splited[1], Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));
                courseList.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
