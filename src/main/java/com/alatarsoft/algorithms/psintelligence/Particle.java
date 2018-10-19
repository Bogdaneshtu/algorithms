package com.alatarsoft.algorithms.psintelligence;

import static com.alatarsoft.algorithms.psintelligence.Constants.NUM_OF_DIMENSIONS;
import static com.alatarsoft.algorithms.psintelligence.Constants.f;

public class Particle {
    private double[] position; // xi -> (x,y)
    private double[] velocity;
    private double[] bestPosition;

    public Particle(double[] position, double[] velocity) {
        this.position = new double[NUM_OF_DIMENSIONS];
        this.velocity = new double[NUM_OF_DIMENSIONS];
        this.bestPosition = new double[NUM_OF_DIMENSIONS];

        System.arraycopy(velocity, 0, this.velocity, 0, velocity.length);
        System.arraycopy(position, 0, this.position, 0, position.length);
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public double[] getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(double[] bestPosition) {
        this.bestPosition = bestPosition;
    }

    public void checkBestSolution(double[] globalBestSolution) {
        if(f(bestPosition) < f(globalBestSolution))
            globalBestSolution = this.bestPosition;
    }

    @Override
    public String toString() {
        return "Best position so far: " + this.bestPosition[0] + "-" + this.bestPosition[1];
    }


}
