package com.alatarsoft.algorithms.genetic;

import java.util.Random;

import static com.alatarsoft.algorithms.genetic.Constants.CHROMOSOME_LENGTH;
import static com.alatarsoft.algorithms.genetic.Constants.CROSSOVER_RATE;
import static com.alatarsoft.algorithms.genetic.Constants.MUTATION_RATE;
import static com.alatarsoft.algorithms.genetic.Constants.TOURNAMENT_SIZE;

public class GeneticAlgorithm {

    private Random randomGenerator;

    public GeneticAlgorithm(){
        this.randomGenerator = new Random();
    }

    public Population evolvePopulation(Population population) {
        Population newPopulation = new Population(population.size());
        for (int i=0;i<population.size();++i) {
            Individual firstIndividual = randomSelection(population);
            Individual secondIndividual = randomSelection(population);
            Individual newIndividual = crossover(firstIndividual, secondIndividual);
            newPopulation.saveIndividual(i, newIndividual);
        }

        for (int i=0;i<population.size();++i)
            mutate(newPopulation.getIndividual(i));

        return newPopulation;
    }

    private void mutate(Individual individual) {
        for(int i=0;i<CHROMOSOME_LENGTH;++i) {
            if(Math.random() <= MUTATION_RATE) {
                int gene = randomGenerator.nextInt(10); // MAX_FITNESS in our case
                individual.setGene(i, gene);
            }
        }

    }

    private Individual crossover(Individual firstIndividual, Individual secondIndividual) {
        Individual newSolution = new Individual();
        for(int i=0;i<CHROMOSOME_LENGTH;++i) {
            if(Math.random() <= CROSSOVER_RATE) {
                newSolution.setGene(i, firstIndividual.getGene(i));
            } else {
                newSolution.setGene(i, secondIndividual.getGene(i));
            }
        }
        return newSolution;
    }

    private Individual randomSelection(Population population) {
        Population newPopulation = new Population(TOURNAMENT_SIZE);
        for (int i=0;i<TOURNAMENT_SIZE;++i) {
            int randomIndex = (int) (Math.random() * population.size());
            newPopulation.saveIndividual(i, population.getIndividual(randomIndex));
        }

        Individual fitestIndividual = newPopulation.getFitestIndividual();
        return fitestIndividual;
    }
}
