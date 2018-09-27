package com.alatarsoft.algorithms.model;

import java.util.Objects;

public class AStarNode {

    /**
     * How far away this node is from the starting point
     */
    private int g;

    /**
     * Hor far away this node is from the end point
     */
    private int h;
    private int rowIndex;
    private int colIndex;

    /**
     * Previous node
     */
    private AStarNode predecessor;

    /**
     * The node can be an obstacle/block
     */
    private boolean isBlock;


    public AStarNode(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }

    public AStarNode getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(AStarNode predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }

    public int getF() {
        return getG() + getH();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AStarNode)) return false;
        AStarNode aStarNode = (AStarNode) o;
        return getRowIndex() == aStarNode.getRowIndex() &&
                getColIndex() == aStarNode.getColIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRowIndex(), getColIndex());
    }

    @Override
    public String toString() {
        return "AStarNode (" + rowIndex + ";" + colIndex + ") h:" + h + " g:" + g + " f:" + getF();
    }
}
