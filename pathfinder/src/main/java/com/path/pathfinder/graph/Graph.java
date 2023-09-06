package com.path.pathfinder.graph;

import java.util.*;

public class Graph {

    private final Map<Vertex, List<Vertex>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getAdjacencyMap() {
        return adjacencyMap;
    }

    public void addVertex(int id) {
        adjacencyMap.put(new Vertex(id), new ArrayList<>());
    }

    public void addEdge(int id1, int id2) {
        adjacencyMap.get(new Vertex(id1)).add(new Vertex(id2));
        adjacencyMap.get(new Vertex(id2)).add(new Vertex(id1));

    }

    public void deleteVertex(int id) {
        if (adjacencyMap.containsKey(new Vertex(id))) {
            adjacencyMap.remove(new Vertex(id));
        }
        adjacencyMap.forEach((k, v) -> {
            if (v.contains(new Vertex(id))){
                v.remove(new Vertex(id));
            }
        });
    }

    public void deleteEdge(int id1, int id2) {
        adjacencyMap.get(new Vertex(id1)).remove(new Vertex(id2));
        adjacencyMap.get(new Vertex(id2)).remove(new Vertex(id1));
    }

    public void showConnections() {
        for (Map.Entry<Vertex, List<Vertex>> v : adjacencyMap.entrySet()) {
            System.out.printf("%-15s  Edges : %10s\n", v.getKey(), v.getValue());
        }
    }

    public Vertex getVertex(int id) {
        Set<Vertex> keySet = adjacencyMap.keySet();

        if (keySet.contains(new Vertex(id))) {
            return new Vertex(id);
        }

        return new Vertex(-1);

    }

    public void removeNeighbours(int id){
        if (adjacencyMap.containsKey(new Vertex(id))) {
            adjacencyMap.get(new Vertex(id)).remove(new Vertex(id));
            adjacencyMap.put(new Vertex(id) ,new ArrayList<>());
        }

        adjacencyMap.forEach((k , v)-> {
            if(v.contains(new Vertex(id))){
                v.remove(new Vertex(id));
            }
        });

    }

    public List<Vertex> getNeighbours(int id) {
        if (adjacencyMap.containsKey(new Vertex(id))) {
            return adjacencyMap.get(new Vertex(id));
        }
        return new ArrayList<>();
    }

    public int getSize() {
        return adjacencyMap.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return Objects.equals(getAdjacencyMap(), graph.getAdjacencyMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdjacencyMap());
    }
}
