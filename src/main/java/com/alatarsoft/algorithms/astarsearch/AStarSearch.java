package com.alatarsoft.algorithms.astarsearch;

import com.alatarsoft.algorithms.model.AStarNode;
import com.alatarsoft.algorithms.util.Constants;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

import static com.alatarsoft.algorithms.util.Constants.A_STAR_COLUMNS;
import static com.alatarsoft.algorithms.util.Constants.A_STAR_ROWS;
import static com.alatarsoft.algorithms.util.Constants.HORIZONTAL_VERTICAL_COST;

public class AStarSearch {

    /**
     * All the nodes/states on the grid
     */
    private AStarNode[][] searchSpace;
    private AStarNode startNode;
    private AStarNode finalNode;
    /**
     * The set of nodes that are already evaluated
     */
    private List<AStarNode> closedSet;
    /**
     * Not yet evaluated
     */
    private Queue<AStarNode> openSet;

    public AStarSearch() {
        this.searchSpace = new AStarNode[A_STAR_ROWS][A_STAR_COLUMNS];
        this.openSet = new PriorityQueue<>(new NodeComparator());
        this.closedSet = new ArrayList<>();
        initializeSearchSpace();
    }

    private void initializeSearchSpace() {

        // initialize all the nodes (states) on the grid
        for (int rowIndex=0;rowIndex<A_STAR_ROWS;rowIndex++) {
            for (int colIndex=0;colIndex<A_STAR_COLUMNS;colIndex++) {
                AStarNode aStarNode = new AStarNode(rowIndex, colIndex);
                searchSpace[rowIndex][colIndex] = aStarNode;
            }
        }

        // set obstacles or blocks
        this.searchSpace[1][7].setBlock(true);
        this.searchSpace[2][3].setBlock(true);
        this.searchSpace[2][4].setBlock(true);
        this.searchSpace[2][5].setBlock(true);
        this.searchSpace[2][6].setBlock(true);
        this.searchSpace[2][7].setBlock(true);

        // start node and final node
        this.startNode = this.searchSpace[3][3];
        this.finalNode = this.searchSpace[1][6];

    }

    public void search() {
        // start with the start node
        startNode.setH(manhattanHeuristic(startNode, finalNode));
        openSet.add(startNode);

        // the algorithm terminates when there is no item left in the open set
        while (!openSet.isEmpty()) {

            // poll: returns the node with the smallest f=h+g value
            AStarNode currentNode = openSet.poll();
            System.out.println(currentNode + " Predecessor is " + currentNode.getPredecessor());

            // if we find the terminal state we've done
            if (currentNode.equals(finalNode)) return;

            // update sets
            openSet.remove(currentNode);
            closedSet.add(currentNode);

            // visit all the neighbors of the actual node
            for (AStarNode neighbor : getAllNeighbors(currentNode)) {
                // we have already considered that state so go on
                if(closedSet.contains(neighbor)) continue;
                // we consider the state so we've done with that one
                if(!openSet.contains(neighbor)) openSet.add(neighbor);

                neighbor.setPredecessor(currentNode);
            }
        }
    }

    private List<AStarNode> getAllNeighbors(AStarNode node) {
        List<AStarNode> neighbors = Lists.newArrayList();
        int row = node.getRowIndex();
        int col = node.getColIndex();

        // block above
        if (row-1>=0 && !searchSpace[row-1][col].isBlock()) {
            AStarNode blockAbove = searchSpace[row-1][col];
            blockAbove.setG(node.getG()+HORIZONTAL_VERTICAL_COST);
            blockAbove.setH(manhattanHeuristic(blockAbove, finalNode));
            neighbors.add(blockAbove);
        }

        // block below
        if (row+1<A_STAR_ROWS && !searchSpace[row+1][col].isBlock()) {
            AStarNode blockBelow = searchSpace[row+1][col];
            blockBelow.setG(node.getG()+HORIZONTAL_VERTICAL_COST);
            blockBelow.setH(manhattanHeuristic(blockBelow, finalNode));
            neighbors.add(blockBelow);
        }

        // block to the left
        if (col-1>=0 && !searchSpace[row][col-1].isBlock()) {
            AStarNode blockToTheLeft = searchSpace[row][col-1];
            blockToTheLeft.setG(node.getG()+HORIZONTAL_VERTICAL_COST);
            blockToTheLeft.setH(manhattanHeuristic(blockToTheLeft, finalNode));
            neighbors.add(blockToTheLeft);
        }

        // block to the right
        if (col+1<A_STAR_COLUMNS && !searchSpace[row][col+1].isBlock()) {
            AStarNode blockToTheRight = searchSpace[row][col+1];
            blockToTheRight.setG(node.getG()+HORIZONTAL_VERTICAL_COST);
            blockToTheRight.setH(manhattanHeuristic(blockToTheRight, finalNode));
            neighbors.add(blockToTheRight);
        }

        return neighbors;
    }

    private int manhattanHeuristic(AStarNode node1, AStarNode node2) {
        return (Math.abs(node1.getRowIndex() - node2.getRowIndex()) +
                Math.abs(node1.getColIndex() - node2.getColIndex()))
                * HORIZONTAL_VERTICAL_COST;
    }

    public void showPath() {
        System.out.println("Shortest path with A* search:");
        AStarNode node = this.finalNode;
        while (Objects.nonNull(node)) {
            System.out.println(node);
            node = node.getPredecessor();
        }
    }
}
