package com.alatarsoft.algorithms.dfsearch;

import com.alatarsoft.algorithms.model.Vertex;

import java.util.Stack;

public class DepthFirstSearch {

    public void iterativeSearch(Vertex root) {
        System.out.println("Depth first search:");
        Stack<Vertex> stack = new Stack<Vertex>(); // LIFO
        root.setVisited(true);
        stack.add(root);
        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();
            actualVertex.setVisited(true);
            System.out.println(actualVertex);
            for (Vertex neighbor : actualVertex.getNeighbors()) {
                if (!neighbor.isVisited()) {
                    stack.add(neighbor);
                }
            }
        }
    }

    public void recursiveSearch(Vertex vertex) {
        System.out.println(vertex);
        for (Vertex neighbor : vertex.getNeighbors()) {
            if (!neighbor.isVisited()) {
                neighbor.setVisited(true);
                recursiveSearch(neighbor);
            }
        }
    }
}
