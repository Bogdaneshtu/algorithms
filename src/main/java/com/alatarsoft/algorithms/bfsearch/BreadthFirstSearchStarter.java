package com.alatarsoft.algorithms.bfsearch;

import static com.alatarsoft.algorithms.bfsearch.DemoDataPreparator.getGrapth;

public class BreadthFirstSearchStarter {

    public static void main(String[] args) {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.iterativeSearch(getGrapth());
    }
}
