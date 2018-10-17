package com.alatarsoft.algorithms.genetic;

import java.util.Random;

import static com.alatarsoft.algorithms.genetic.Constants.CHROMOSOME_LENGTH;
import static com.alatarsoft.algorithms.genetic.Constants.SOLUTION_SEQUENCE;

public class Individual {

    private int[] genes;
    private int fitness;
    private Random randomGenerator;

    public Individual() {
        this.genes = new int[CHROMOSOME_LENGTH];
        this.randomGenerator = new Random();
    }

    public void generateIndividual() {
        for (int i=0;i<CHROMOSOME_LENGTH;++i) {
            int gene = randomGenerator.nextInt(10);
            genes[i] = gene;
        }
    }

    public int getFitness() {
        if (fitness == 0) {
            for (int i=0;i<CHROMOSOME_LENGTH;++i)
                if (getGene(i) == SOLUTION_SEQUENCE[i])
                    this.fitness++;
        }
        return fitness;
    }

    public int getGene(int index) {
        return this.genes[index];
    }

    public void setGene(int index, int value) {
        this.genes[index] = value;
        this.fitness = 0;
    }

    public String toString() {
        String s = "";
        for (int i=0;i<CHROMOSOME_LENGTH;++i)
            s += getGene(i) + " ";
        return s;
    }


}
