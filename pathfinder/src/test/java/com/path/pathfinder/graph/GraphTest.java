package com.path.pathfinder.graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private final Graph testGraph = new Graph();
    private Graph dummygraph = new Graph();

    @BeforeEach
    void setUp() {
        testGraph.addVertex(0);
        testGraph.addVertex(1);
        testGraph.addVertex(2);
        testGraph.addVertex(3);

        testGraph.addEdge(1, 2);

        dummygraph.addVertex(0);
        dummygraph.addVertex(1);
        dummygraph.addVertex(2);
        dummygraph.addVertex(3);

        dummygraph.addEdge(1, 2);
        dummygraph.addEdge(2, 3);


    }

    @Test
    @DisplayName("Adding Vertex to Map")
    void addVertex_should_not_be_empty() {
        testGraph.addVertex(1);
        assertFalse(testGraph.getAdjacencyMap().isEmpty());
    }

    @Test
    @DisplayName("Graphs are not equal")
    void graph_should_not_be_equal() {
        assertNotEquals(testGraph, dummygraph);
    }


    @Test
    @DisplayName("Delete edge connection")
    void delete_edge_should_remove_vertex_from_value_list() {

        dummygraph.deleteEdge(2, 3);
        assertEquals(testGraph, dummygraph);

    }



}