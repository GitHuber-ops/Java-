package com.company;

import static java.lang.System.out;

public class Student {
    private String name;
    private String number;
    private String sex;
    private int age;

    Student(String name, String number, String sex, int age){
        this.name = name;
        this.number = number;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("(%s, %s, %s, %d)" ,this.name, this.number, this.sex, this.age);
    }

    void getName(){
        out.println(this.name);
    }

    void getNumber(){
        out.println(this.number);
    }

    void getSex(){
        out.println(this.sex);
    }

    void getAge(){
        out.println(this.age);
    }
}
