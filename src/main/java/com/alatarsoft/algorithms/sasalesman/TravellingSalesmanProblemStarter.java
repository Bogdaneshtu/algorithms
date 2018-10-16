package com.alatarsoft.algorithms.sasalesman;

public class TravellingSalesmanProblemStarter {

    public static void main(String[] args) {
        for(int i=0;i<100;i++) {
            City city = new City();
            Repository.addCity(city);
        }

        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
        simulatedAnnealing.simulation();

        System.out.println("Final solution's distance is " + simulatedAnnealing.getBestTour().getDistance());
        System.out.println("Tour: " + simulatedAnnealing.getBestTour());
    }
}
