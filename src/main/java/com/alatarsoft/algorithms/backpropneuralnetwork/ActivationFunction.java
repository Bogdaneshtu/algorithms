package com.alatarsoft.algorithms.backpropneuralnetwork;

public class ActivationFunction {

    public static float sigmoid(float x) {
        return (float) (1/ (1+Math.exp(-x)));
    }

    public static float dSigmoig(float x) {
        return x * (1-x);
    }
}
