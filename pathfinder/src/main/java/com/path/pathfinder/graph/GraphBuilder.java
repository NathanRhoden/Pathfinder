package com.path.pathfinder.graph;

import com.path.pathfinder.render.Render;
import com.path.pathfinder.util.DimensionData;
import com.path.pathfinder.util.VertexList;

import java.util.Iterator;
import java.util.Objects;

public class GraphBuilder implements Observer {

    private Graph graph;
    private int row;
    private int col;

    public GraphBuilder(DimensionData dimensionData) {

        graph = new Graph();
        row = dimensionData.getRow();
        col = dimensionData.getCol();
    }

    public void buildGraph() {

        generateVertex();
        generateVerticalEdges();
        generateHorizontalEdges();

    }

    public void generateVertex() {

        for (int i = 0; i < row * col; i++) {
            graph.addVertex(i);
        }
    }

    public void removeVertexConnection(int id){
        System.out.println(id + " Removed");
        var connections = graph.getNeighbours(id);

        graph.removeNeighbours(id);
        System.out.println(graph.getNeighbours(id).toString());


    }

    @Override
    public void update(Object o) {
        removeVertexConnection((int) o);
    }

    public void generateHorizontalEdges() {

        int rowCount = 1;

        for (int i = 1; i < (row * col); i++) {

            if (rowCount != row) {
                graph.addEdge(i, i - 1);
                rowCount++;
            } else {
                rowCount = 1;
            }

        }

    }

    public void generateVerticalEdges() {
        for (int i = 0; i < (row * col) - row; i++) {
            graph.addEdge(i, i + row);
        }
    }

    public void resetGraph(){
        graph.getAdjacencyMap().clear();
        buildGraph();

    }

    public Graph getGraph() {
        return graph;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphBuilder that = (GraphBuilder) o;
        return row == that.row && col == that.col && getGraph().equals(that.getGraph());
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
