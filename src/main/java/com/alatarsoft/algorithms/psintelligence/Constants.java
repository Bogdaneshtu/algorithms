package com.alatarsoft.algorithms.psintelligence;

public class Constants {

    private Constants() {

    }

    public static final int NUM_OF_DIMENSIONS = 2;
    public static final int NUM_PARTICLES = 10;
    public static final int MAX_ITERATIONS = 10000;
    public static final double MIN = -2;
    public static final double MAX = 2;
    public static final double w = 0.729;
    public static final double c1 = 1.49;
    public static final double c2 = 1.49;

    public static final double f(double[] data) {
        return Math.exp(-data[0]*data[0] - data[1]*data[1])*Math.sin(data[0]);
    }
}
