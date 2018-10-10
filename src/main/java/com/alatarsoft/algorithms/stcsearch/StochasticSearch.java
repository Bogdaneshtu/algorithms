package com.alatarsoft.algorithms.stcsearch;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class StochasticSearch {

    private static Random random = new Random();
    public static final double START_X = -1;
    private static final double END_X = 2;

    public static double f(double x) {
        return (x-1)*(x-1)-1;
    }

    public static void stochasticSearch() {
        double startPointX = START_X;
        double max = f(startPointX);
        double maxX = startPointX;

        for (int i=0;i<10000;++i) {
            double randomX = ThreadLocalRandom.current().nextDouble(START_X, END_X);
            if (f(randomX) > max) {
                max = f(randomX);
                maxX = randomX;
            }
        }

        System.out.println("The maximum is f(x) = " + max + " and maxX is " + maxX);
    }

    public static void main(String[] args) {
        stochasticSearch();
    }
}
