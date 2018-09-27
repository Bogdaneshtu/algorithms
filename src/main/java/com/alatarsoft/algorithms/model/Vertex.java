package com.alatarsoft.algorithms.model;

import com.google.common.collect.Lists;

import java.util.List;

public class Vertex {
    private String name;
    private boolean visited = false;
    private List<Vertex> neighbors = Lists.newArrayList();
    private int depthLevel = 0;

    public Vertex(String name) {
        this.name = name;
    }

    public Vertex(int value) {
        this.name = String.valueOf(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepthLevel() {
        return depthLevel;
    }

    public void setDepthLevel(int depthLevel) {
        this.depthLevel = depthLevel;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Vertex> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighborVertex(Vertex neighborVertex) {
        neighbors.add(neighborVertex);
    }

    @Override
    public String toString() {
        return name;
    }
}
