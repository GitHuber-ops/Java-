package com.company;

import static java.lang.System.out;

public class Point {

    private int x;
    private int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    Point(){
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int Y){
        this.y = y;
    }

    public void getPoint(){
        out.printf("(%d, %d)\n", this.x, this.y);
    }

    public void movePoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}


