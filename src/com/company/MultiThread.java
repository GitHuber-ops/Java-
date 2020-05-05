package com.company;

public class MultiThread {
    public static void main(String args[]){
        Thread thread = new Thread(() -> {
                while (true)
                    System.out.println("hhh");
        });
        //thread.setDaemon(true);
        thread.start();
    }
}
