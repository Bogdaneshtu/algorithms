package com.alatarsoft.algorithms.iddfsearch;

import static com.alatarsoft.algorithms.iddfsearch.DemoDataPreparator.getGrapth;

public class Starter {

    public static void main(String[] args) {
        IterativeDeepingDepthFirstSearch iterativeDeepingDepthFirstSearch = new IterativeDeepingDepthFirstSearch("5");
        iterativeDeepingDepthFirstSearch.iterativeSearch(getGrapth());

    }
}
