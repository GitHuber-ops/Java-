package com.company;

import static java.lang.System.out;
import com.company.Student;

public class StuedentTest {
    public static void main(String args[]){
        Student student1 = new Student("student1", "001", "male", 11);
        Student student2 = new Student("student2", "002", "female", 22);
        Student student3 = new Student("student3", "003", "male", 33);

        out.println(student1);
        out.println(student2);
        out.println(student3);
    }
}
