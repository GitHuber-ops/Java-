package com.company;

import java.util.Scanner;

import static com.company.AcademicTeacher.courseManagement;
import static com.company.PrintModule.printAll;
import static com.company.Search.*;

public class WelcomeAndChoose {
    public static void welcome() {
        System.out.println("Welcome to students' score management system!\n" +
                "You can take choose the following methods by input corresponding letter!\n" +
                "If you are a student, please input \"S\"\n" +
                "If you are a teacher, please input \"T\"\n" +
                "If you are a academic teacher, please input \"O\"\n" +
                "If you are a administration, please input \"A\"\n" +
                "You can quit the system whenever you want by inputting \"Q\"");
    }

    public static void sectionChoose() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            welcome();
            char chosen = scanner.next().charAt(0); ///Careful, not sure if it's OK...
            switch (chosen) {
                case 'S':
                    studentChoose();  //OK
                    break;
                case 'T':
                    teacherChoose();  //OK
                    break;
                case 'O':
                    academicChoose();  //OK
                    break;
                case 'A':
                    adminChoose();  //OK
                    break;
                case 'Q':
                    return;
                default:
                    System.out.println("Invalid option, please input again...");  //OK
                    break;
            }
        }
    }

    public static void adminWelcome() {
        System.out.println("Hi,input \"S\" to maintain student information\n" +
                "\"T\" to maintain teacher information\n" +
                "\"O\" to maintain score information\n" +
                "You can go back to the previous page whenever you want by inputting \"Q\"");
    }

    public static void adminSectionChoose() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            adminWelcome();
            char chosen = scanner.next().charAt(0); ///Careful, not sure if it's OK...
            switch (chosen) {
                case 'S':
                    studentChoose();  //OK
                    break;
                case 'T':
                    teacherChoose();  //OK
                    break;
                case 'O':
                    academicChoose();  //OK
                    break;
                case 'Q':
                    return;
                default:
                    System.out.println("Invalid option, please input again...");  //OK
                    break;
            }
        }
    }

    public static void studentChoose() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your student's number: ");
        String number = scanner.next();                        //Member variables number will be used in this part.

        Student student = studentSearch(number);
        if (student == null) {
            System.out.println("Nonexistence number!\n");
            return;
        }

        while (true) {
            System.out.println("Hi, input \"M\" to maintain your personal information\n" +
                    "\"C\" to inquire your courses\n" +
                    "\"S\" to inquire your scores\n" +
                    "\"A\" to add a course\n" +
                    "You can go back to the previous page whenever you want by inputting \"Q\"");

            char chosen = scanner.next().charAt(0);
            switch (chosen) {
                case 'M':
                    System.out.println("Please input your personal information by the following format (number name sex birthday academy major): ");
                    student.setStudent(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next());     //OK
                    break;
                case 'C':
                    student.studentInquire();  //OK
                    break;
                case 'S':
                    studentScoreSearch(number);     //OK
                    break;
                case 'A':
                    student.addCourse();   //OK
                case 'Q':
                    return;
                default:
                    System.out.println("Invalid option, please input again...");
                    break;
            }
        }
    }

    public static void teacherChoose() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your teacher's number: ");
        String number = scanner.next();
        Teacher teacher = teacherSearch(number);
        if (teacher == null) {
            System.out.println("Nonexistence number!\n");
            return;
        }

        while (true) {
            System.out.println("Hi, input \"M\" to maintain your personal information\n" +
                    "\"C\" to inquire your courses\n" +
                    "\"S\" to inquire your scores\n" +
                    "\"A\" to add a course\n" +
                    "You can go back to the previous page whenever you want by inputting \"Q\"");

            char chosen = scanner.next().charAt(0);
            switch (chosen) {
                case 'M':
                    System.out.println("Please input your personal information by the following format (number name academy major): ");
                    teacher.setTeacher(scanner.next(), scanner.next(), scanner.next(), scanner.next());    //OK
                    break;
                case 'C':
                    teacher.teacherInquire();   //OK
                    break;
                case 'S':
                    teacherScoreSearch(number);     //OK
                    break;
                case 'A':
                    teacher.addCourse();   //OK
                case 'Q':
                    return;
                default:
                    System.out.println("Invalid option, please input again...");
                    break;
            }
        }
    }

    public static void academicChoose() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your academic's number: ");
        String number = scanner.next();
        AcademicTeacher teacher = academicTeacherSearch(number);
        if (teacher == null) {
            System.out.println("Nonexistence number!\n");
            return;
        }

        while (true) {
            System.out.println("Hi, input \"M\" to maintain your personal information\n" +
                    "\"C\" to manage courses\n" +
                    "\"R\" to rank the scores\n" +
                    "\"P\" to print the statement\n" +
                    "You can go back to the previous page whenever you want by inputting \"Q\"");

            char chosen = scanner.next().charAt(0);
            switch (chosen) {
                case 'M':
                    System.out.println("Please input your personal information by the following format (number name academy): ");
                    teacher.setAcademicTeacher(scanner.next(), scanner.next(), scanner.next());   //OK
                    break;
                case 'C':
                    courseManagement();    //Temporarily ignore..
                    break;
                case 'R':
                    System.out.println("The following scores were sorted from low to high according to the score: ");
                    teacher.rank();   //OK
                    break;
                case 'P':
                    printAll();    //OK
                case 'Q':
                    return;
                default:
                    System.out.println("Invalid option, please input again...");  //OK
                    break;
            }
        }
    }

    public static void adminChoose() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input admin password: ");
        String password = scanner.next();
        if (!password.equals(Admin.password)) {
            System.out.println("Wrong password!\n");
            return;
        }
        adminSectionChoose();
    }
}
