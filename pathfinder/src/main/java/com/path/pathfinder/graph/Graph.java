package com.path.pathfinder.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Vertex, List<Vertex>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getAdjacencyMap() {
        return adjacencyMap;
    }
    public void addVertex(int id){
        adjacencyMap.put(new Vertex(id) , new ArrayList<>());
    }

}
