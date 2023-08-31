package com.path.pathfinder.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Vertex, List<Vertex>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getAdjacencyMap() {
        return adjacencyMap;
    }
    public void addVertex(int id){
        adjacencyMap.put(new Vertex(id) , new ArrayList<>());
    }

    public void addEdge(int id1 , int id2){
        adjacencyMap.get(new Vertex(id1)).add(new Vertex(id2));
        adjacencyMap.get(new Vertex(id2)).add(new Vertex(id1));

    }

    public void deleteEdge(int id1 , int id2){
        adjacencyMap.get(new Vertex(id1)).remove(new Vertex(id2));
        adjacencyMap.get(new Vertex(id2)).remove(new Vertex(id1));
    }

    public void showConnection(){
        for (Map.Entry<Vertex , List<Vertex>> v : adjacencyMap.entrySet()) {
            System.out.printf("%-15s  Edges : %10s\n" , v.getKey() , v.getValue());
        }
    }


}
