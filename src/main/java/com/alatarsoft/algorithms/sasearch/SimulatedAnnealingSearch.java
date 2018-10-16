package com.alatarsoft.algorithms.sasearch;

import java.util.Random;

import static com.alatarsoft.algorithms.sasearch.Constants.COOLING_RATE;
import static com.alatarsoft.algorithms.sasearch.Constants.MAX_TEMPERATURE;
import static com.alatarsoft.algorithms.sasearch.Constants.MIN_COORDINATE;
import static com.alatarsoft.algorithms.sasearch.Constants.MIN_TEMPERATURE;

public class SimulatedAnnealingSearch {

    private Random randomGenerator;
    private double currentCoordinateX;
    private double nextCoordinateX;
    private double bestCoordinateX;

    public void findOptimum() {
        double temperature = MAX_TEMPERATURE;

        while (temperature > MIN_TEMPERATURE) {
            nextCoordinateX = getRandomX();
            double actualEnergy = getEnergy(currentCoordinateX);
            double newEnergy = getEnergy(nextCoordinateX);
            if (acceptanceProbability(actualEnergy, newEnergy, temperature) > Math.random()) {
                currentCoordinateX = nextCoordinateX;
            }

            if (f(currentCoordinateX) < f(bestCoordinateX)) {
                bestCoordinateX = currentCoordinateX;
            }

            temperature *= 1 - COOLING_RATE;
        }

        System.out.println("Global extremum guess: x=" + bestCoordinateX + " f(x)=" + f(bestCoordinateX));
    }

    public double getRandomX() {
        return randomGenerator.nextDouble() * (MAX_TEMPERATURE - MIN_COORDINATE) + MIN_COORDINATE;
    }

    public SimulatedAnnealingSearch() {
        this.randomGenerator = new Random();
    }

    public double getEnergy(double x) {
        return f(x);
    }

    public double f(double x) {
        return (x-0.3)*(x-0.3)*(x-0.3)-5*x+x*x-2;
    }

    public double acceptanceProbability(double energy, double newEnergy, double temperature){
        if (newEnergy < energy) {
            return 1;
        }
        return Math.exp((energy-newEnergy)/temperature);
    }
}
