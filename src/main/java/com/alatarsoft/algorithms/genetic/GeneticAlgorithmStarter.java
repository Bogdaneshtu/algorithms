package com.alatarsoft.algorithms.genetic;

import static com.alatarsoft.algorithms.genetic.Constants.MAX_FITNESS;

public class GeneticAlgorithmStarter {

    public static void main(String[] args) {
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        Population population = new Population(100);
        population.initialize();
        int generationCounter = 0;
        while(population.getFitestIndividual().getFitness() != MAX_FITNESS){
            ++generationCounter;
            System.out.println("Generation " + generationCounter + " - fittest is: " + population.getFitestIndividual().getFitness());
            System.out.println(population.getFitestIndividual() + "\n");
            population = geneticAlgorithm.evolvePopulation(population);
        }

        System.out.println("Solution found!");
        System.out.println(population.getFitestIndividual());
    }
}
