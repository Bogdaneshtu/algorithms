package com.alatarsoft.algorithms;

import com.alatarsoft.algorithms.astarsearch.AStarSearch;
import com.alatarsoft.algorithms.bfsearch.BreadthFirstSearch;
import com.alatarsoft.algorithms.dfsearch.DepthFirstSearch;
import com.alatarsoft.algorithms.iddfsearch.IterativeDeepingDepthFirstSearch;
import com.alatarsoft.algorithms.util.DemoDataPreparator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.alatarsoft.algorithms.util.DemoDataPreparator.getGrapth;

@SpringBootApplication
public class AlgorithmsApplication {

	public static void main(String[] args) {
		/*BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		breadthFirstSearch.iterativeSearch(getGrapth());
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
		depthFirstSearch.iterativeSearch(getGrapth());
		depthFirstSearch.recursiveSearch(getGrapth());
		IterativeDeepingDepthFirstSearch iterativeDeepingDepthFirstSearch = new IterativeDeepingDepthFirstSearch("5");
		iterativeDeepingDepthFirstSearch.iterativeSearch(getGrapth());*/
		AStarSearch aStarSearch = new AStarSearch();
		aStarSearch.search();
		aStarSearch.showPath();
		//SpringApplication.run(AlgorithmsApplication.class, args);
	}
}
