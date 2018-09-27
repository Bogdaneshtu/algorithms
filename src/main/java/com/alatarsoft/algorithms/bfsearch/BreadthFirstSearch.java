package com.alatarsoft.algorithms.bfsearch;

import com.alatarsoft.algorithms.model.Vertex;
import com.google.common.collect.Lists;

import java.util.Queue;

public class BreadthFirstSearch {

    public void iterativeSearch(Vertex root) {
        System.out.println("Breadth first search:");
        Queue<Vertex> queue = Lists.newLinkedList(); // FIFO
        queue.add(root);
        root.setVisited(true);
        while (!queue.isEmpty()) {
            Vertex actualVertex = queue.remove();
            System.out.println(actualVertex);
            for (Vertex neighbor : actualVertex.getNeighbors()) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                }
            }
        }
    }
}
