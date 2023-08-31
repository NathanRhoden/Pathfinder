package com.path.pathfinder.graph;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private final Graph testGraph = new Graph();

    @Test
    @DisplayName("Adding Vertex to Map")
    void addVertex_should_not_be_empty() {
        testGraph.addVertex(1);
        assertTrue(!testGraph.getAdjacencyMap().isEmpty());
    }
}