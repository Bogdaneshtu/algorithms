package com.alatarsoft.algorithms.genetic;

public class Population {

    private Individual[] individuals;

    public Population(int populationSize) {
        individuals = new Individual[populationSize];
    }

    public void initialize() {
        for (int i=0;i<individuals.length;++i) {
            Individual newIndividual = new Individual();
            newIndividual.generateIndividual();
            saveIndividual(i, newIndividual);
        }

    }

    public void saveIndividual(int index, Individual individual) {
        this.individuals[index] = individual;
    }

    public Individual getIndividual(int index) {
        return this.individuals[index];
    }

    public Individual getFittestIndividual() {
        Individual fitest = individuals[0];
        for (int i=0;i<individuals.length;++i)
            if(getIndividual(i).getFitness() >= fitest.getFitness())
                fitest = getIndividual(i);
        return fitest;
    }

    public int size() {
        return this.individuals.length;
    }
}
