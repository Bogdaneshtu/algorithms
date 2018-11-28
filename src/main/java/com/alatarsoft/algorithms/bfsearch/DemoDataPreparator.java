package com.alatarsoft.algorithms.bfsearch;

import com.alatarsoft.algorithms.model.Vertex;

public class DemoDataPreparator {

    public static Vertex getGrapth() {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        vertex1.addNeighborVertex(vertex2);
        vertex1.addNeighborVertex(vertex4);
        vertex4.addNeighborVertex(vertex5);
        vertex2.addNeighborVertex(vertex3);
        return vertex1;
    }
}
