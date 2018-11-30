package com.alatarsoft.algorithms.dfsearch;

import static com.alatarsoft.algorithms.dfsearch.DemoDataPreparator.getGrapth;

public class DepthFirstSearchStarter {

    public static void main(String[] args) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.iterativeSearch(getGrapth());
        System.out.println("=====");
        depthFirstSearch.recursiveSearch(getGrapth());
    }

}
