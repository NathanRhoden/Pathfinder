package com.path.pathfinder.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphBuilder {

    private Graph graph;
    private int rowLength;
    private int columnLength;

    public GraphBuilder(int rowLength, int columnLength) {

        graph = new Graph();
        this.rowLength = rowLength;
        this.columnLength = columnLength;
    }

    public void buildGraph() {

        generateVertex();

    }

    private void generateVertex(){

        for (int i = 0; i <  rowLength * columnLength; i++) {
            graph.addVertex(i);
        }
    }




    public Graph getGraph() {
        return graph;
    }
}
