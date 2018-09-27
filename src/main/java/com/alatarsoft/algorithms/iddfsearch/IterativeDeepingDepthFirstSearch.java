package com.alatarsoft.algorithms.iddfsearch;

import com.alatarsoft.algorithms.model.Vertex;

import java.util.Stack;

public class IterativeDeepingDepthFirstSearch {

    private String target;
    private boolean isTagetFound = false;

    public IterativeDeepingDepthFirstSearch(String target) {
        this.target = target;
    }

    public void iterativeSearch(Vertex root) {
        int depth = 0;
        while (!isTagetFound) {
            System.out.println();
            depthFirstSearch(root, depth);
            depth++;
        }
    }

    private void depthFirstSearch(Vertex root, int depthLevel) {
        Stack<Vertex> stack = new Stack<>();
        root.setDepthLevel(0);
        stack.push(root);

        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();
            System.out.print(actualVertex + " ");
            if (actualVertex.getName().equals(target)) {
                System.out.println("Node has been found.");
                isTagetFound = true;
                return;
            }

            if (actualVertex.getDepthLevel() >= depthLevel) {
                continue;
            }

            for (Vertex neighbor : actualVertex.getNeighbors()) {
                neighbor.setDepthLevel(actualVertex.getDepthLevel() + 1);
                stack.push(neighbor);
            }
        }
    }
}
