package com.alatarsoft.algorithms.backpropneuralnetwork;

import static com.alatarsoft.algorithms.backpropneuralnetwork.Constants.ITERATIONS;
import static com.alatarsoft.algorithms.backpropneuralnetwork.Constants.LEARNING_RATE;
import static com.alatarsoft.algorithms.backpropneuralnetwork.Constants.MOMENTUM;

public class BackpropagationStarter {

    public static void main(String[] args) {
        float[][] trainingData = new float[][] {
                new float[] {0,0},
                new float[] {0,1},
                new float[] {1,0},
                new float[] {1,1}
        };

        float[][] trainingOutput = new float[][] {
                new float[] {0},
                new float[] {0},
                new float[] {0},
                new float[] {1}
        };

        BackpropagationNeuralNetwork backpropagationNeuralNetwork =
                new BackpropagationNeuralNetwork(2, 3, 1);
        for (int iteraton = 0;iteraton < ITERATIONS; iteraton++) {
            for (int i=0;i<trainingOutput.length;i++) {
                backpropagationNeuralNetwork.train(trainingData[i], trainingOutput[i], LEARNING_RATE, MOMENTUM);
            }
            System.out.println();
            for (int i=0;i<trainingOutput.length;i++) {
                float[] trainingDataRow = trainingData[i];
                System.out.println("Num of iterations: " + iteraton + 1);
                System.out.printf("%.1f, %.1f --> %.3f\n", trainingDataRow[0], trainingDataRow[1], backpropagationNeuralNetwork.run(trainingDataRow)[0]);
            }
        }
    }
}
