package com.company;

import java.util.List;

import static com.company.IOModule.*;

public class PrintModule {
    public static void print(List list){
        for(Object o : list){
            if(o != null)
                System.out.println(o);
        }
    }

    public static void print(Object[] objects){
        for(Object o : objects){
            if(o != null)
                System.out.println(o);
        }
    }

    public static void printAll(){
        com.company.PrintModule.print(studentList);
        com.company.PrintModule.print(scoreList);
        com.company.PrintModule.print(courseList);
        com.company.PrintModule.print(teacherList);
        com.company.PrintModule.print(academicTeacherList);
    }
}
