package com.path.pathfinder.graph;

import com.path.pathfinder.util.DimensionData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
class GraphBuilderTest {

    DimensionData dimensionData = new DimensionData(1000 , 1000, 2 ,2);
    GraphBuilder mockGraph = new GraphBuilder(dimensionData);

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

        GraphBuilder g = new GraphBuilder(dimensionData);
        g.generateVertex();
        g.generateHorizontalEdges();

        assertEquals(mockGraph, g);

    }
}