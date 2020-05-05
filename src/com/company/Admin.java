package com.company;

import java.util.Scanner;

public class Admin {
    static String password;

    Admin(String password){
        this.password = password;
    }

    public static void setPassword(){
        String password1, password2;
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please set your admin password: ");
            password1 = scanner.nextLine();
            System.out.println("Input again: ");
            password2 = scanner.nextLine();
            if(password1.equals(password2))
                break;
            System.out.println("Password do not match, try again...");
        }
        System.out.println("Set successfully!");
        Admin.password = password1;
    }
}
