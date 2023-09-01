package com.path.pathfinder.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphBuilderTest {

    GraphBuilder mockGraph = new GraphBuilder(2, 2);

    @BeforeEach
    void setUp() {
        mockGraph.getGraph().addVertex(0);
        mockGraph.getGraph().addVertex(1);
        mockGraph.getGraph().addVertex(2);
        mockGraph.getGraph().addVertex(3);

        mockGraph.getGraph().addEdge(0, 1);
        mockGraph.getGraph().addEdge(2, 3);

    }

    @Test
    @DisplayName("Correct horizontal edge connections")
    void generateHorizontalEdges() {

        GraphBuilder g = new GraphBuilder(2, 2);
        g.buildGraph();
        g.generateHorizontalEdges();

        assertSame(mockGraph, g);

    }
}