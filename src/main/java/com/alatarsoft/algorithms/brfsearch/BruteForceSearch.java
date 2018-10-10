package com.alatarsoft.algorithms.brfsearch;

public class BruteForceSearch {

    private static final double START_X = -1;
    public static final double END_X = 2;
    // interval is [START_X, END_X]

    public static double f(double x) {
        return -1*(x-1)*(x-1) + 2;
    }

    public static void bruteForceSearch() {
        double startingPoit = START_X;
        double max = f(startingPoit);
        double dx = 0.1;
        for (double i=startingPoit;i < END_X;i+=dx) {
            if(f(i) > max)
                 max = f(i);
        }
        System.out.println("The maximum value if f(x) = " + max);
    }

    public static void main(String[] args) {
        bruteForceSearch();
    }

}
