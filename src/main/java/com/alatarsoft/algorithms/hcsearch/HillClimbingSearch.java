package com.alatarsoft.algorithms.hcsearch;

public class HillClimbingSearch {

    public static double START_INTERVAL = -2;
    public static double END_INTERVAL = 2;


    public static double f(double x) {
        return -(x-1)*(x-1)+2;
    }

    public static void hillClimbing() {
        double dx = 0.1;
        double actualPointX = START_INTERVAL;
        double max = f(actualPointX);
        while(f(actualPointX) >= max) {
            max = f(actualPointX);
            System.out.println("x=" + actualPointX + " f(x)=" + f(actualPointX));
            actualPointX = actualPointX + dx;
        }
        System.out.println("Maximum is " + max);
    }

    public static void main(String[] args) {
        hillClimbing();
    }
}
