package com.company;

import java.io.EOFException;
import java.util.LinkedList;
import java.util.List;

public class IOModule {
    static List<Student> studentList = new LinkedList<>();
    static List<Score> scoreList = new LinkedList<>();
    static List<Course> courseList = new LinkedList<>();
    static List<Teacher> teacherList = new LinkedList<>();
    static List<AcademicTeacher> academicTeacherList = new LinkedList<>();


    public static void saveStudents(){
        for(Student student : studentList){
            student.save();
        }
    }


    public static void saveScores(){
        for(Score score : scoreList){
            score.save();
        }
    }


    public static void saveCourses(){
        for(Course course : courseList){
            course.save();
        }
    }


    public static void saveTeachers(){
        for(Teacher teacher : teacherList){
            teacher.save();
        }
    }

    public static void saveAcademicTeachers(){
        for(AcademicTeacher teacher : academicTeacherList){
            teacher.save();
        }
    }


    public static void load() throws EOFException {
        Student.load();
        Score.load();
        Course.load();
        Teacher.load();
        AcademicTeacher.load();
    }

    public static void save(){
        saveStudents();
        saveCourses();
        saveScores();
        saveTeachers();
        saveAcademicTeachers();
    }
}
