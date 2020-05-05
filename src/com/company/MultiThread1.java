package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThread1 {
    public static void main(String args[]){
        Thread addOne1 = new Thread(new AddOne());
        Thread addOne2 = new Thread(new AddOne());
        Thread subOne1 = new Thread(new SubOne());
        Thread subOne2 = new Thread(new SubOne());
        addOne1.start();
        addOne2.start();
        subOne1.start();
        subOne2.start();
    }
}

class AddOne implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 10; i++)
            System.out.println(i);
    }
}

class SubOne implements Runnable{

    @Override
    public void run() {
        for(int i = 10; i > 0; i--)
            System.out.println(i);
    }
}


