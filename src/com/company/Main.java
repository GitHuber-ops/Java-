package com.company;

import java.io.EOFException;

import static com.company.Admin.setPassword;
import static com.company.IOModule.save;
import static com.company.PrintModule.printAll;
import static com.company.WelcomeAndChoose.sectionChoose;

public class Main {
    public static void main(String[] args) {
        try {
            setPassword();
            IOModule.load();
            //printAll();
            sectionChoose();
        }catch (EOFException e){
            e.printStackTrace();
        }finally {
            save();
        }
    }
}
