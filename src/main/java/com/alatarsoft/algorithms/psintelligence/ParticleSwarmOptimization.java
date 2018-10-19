package com.alatarsoft.algorithms.psintelligence;

import static com.alatarsoft.algorithms.psintelligence.Constants.MAX;
import static com.alatarsoft.algorithms.psintelligence.Constants.MAX_ITERATIONS;
import static com.alatarsoft.algorithms.psintelligence.Constants.MIN;
import static com.alatarsoft.algorithms.psintelligence.Constants.NUM_OF_DIMENSIONS;
import static com.alatarsoft.algorithms.psintelligence.Constants.NUM_PARTICLES;
import static com.alatarsoft.algorithms.psintelligence.Constants.c1;
import static com.alatarsoft.algorithms.psintelligence.Constants.c2;
import static com.alatarsoft.algorithms.psintelligence.Constants.f;
import static com.alatarsoft.algorithms.psintelligence.Constants.w;

public class ParticleSwarmOptimization {

    private double[] globalBestSolutions;
    private Particle[] particleSwarm;
    private int epochs;

    public ParticleSwarmOptimization() {
        this.globalBestSolutions = new double[NUM_OF_DIMENSIONS];
        this.particleSwarm = new Particle[NUM_PARTICLES];
        generateRandomSolution();
    }

    public void solve() {
        // initialize particles
        for (int i=0;i<NUM_PARTICLES;++i) {
            double[] locations = initializeLocation();
            double[] velocities = initializeVelocity();
            this.particleSwarm[i] = new Particle(locations, velocities);
        }

        while(this.epochs < MAX_ITERATIONS) {
            for (Particle actualParticle : this.particleSwarm) {
                // updating the velocities
                for (int i=0;i<actualParticle.getVelocity().length; ++i) {
                    double rp = Math.random();
                    double rg = Math.random();
                    actualParticle.getVelocity()[i] = w * actualParticle.getVelocity()[i]
                            + c1 * rp * (actualParticle.getBestPosition()[i] - actualParticle.getPosition()[i])
                            + c2 * rg * (this.globalBestSolutions[i] - actualParticle.getPosition()[i]);
                }

                // update the positions
                for (int i=0;i<actualParticle.getPosition().length;++i) {
                    actualParticle.getPosition()[i] += actualParticle.getVelocity()[i];
                    if (actualParticle.getPosition()[i] < MIN) {
                        actualParticle.getPosition()[i] = MIN;
                    } else if (actualParticle.getPosition()[i] > MAX) {
                        actualParticle.getPosition()[i] = MAX;
                    }
                }

                if (f(actualParticle.getPosition()) < f(actualParticle.getBestPosition())) {
                    actualParticle.setBestPosition(actualParticle.getPosition());
                }

                if (f(actualParticle.getPosition()) < f(globalBestSolutions)) {
                    System.arraycopy(actualParticle.getBestPosition(), 0, globalBestSolutions, 0, actualParticle.getBestPosition().length);
                }
            }
            this.epochs++;
        }
    }

    private void generateRandomSolution() {
        for(int i=0;i<NUM_OF_DIMENSIONS;++i) {
            double randCoordinate = random(MIN, MAX);
            this.globalBestSolutions[i] = randCoordinate;
        }
    }

    private double[] initializeLocation() {
        double x = random(MIN, MAX);
        double y = random(MIN, MAX);
        double[] newLocation = new double[]{x,y};
        return newLocation;
    }

    private double[] initializeVelocity() {
        double vx = random(-(MAX-MIN), MAX-MIN);
        double vy = random(-(MAX-MIN), MAX-MIN);
        double[] newVelocity = new double[]{vx, vy};
        return newVelocity;
    }

    private double random(double min, double max) {
        return min + (max-min) * Math.random();
    }

    public void showSolution() {
        System.out.println("Solution for PSO problem: ");
        System.out.println("Best solution x:" + this.globalBestSolutions[0] + " - y:" + this.globalBestSolutions[1]);
        System.out.println("Value f(x,y) = " + f(this.globalBestSolutions));
    }
}
