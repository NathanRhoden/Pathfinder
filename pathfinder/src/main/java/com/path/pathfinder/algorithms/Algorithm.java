package com.path.pathfinder.algorithms;

import com.path.pathfinder.graph.Graph;
import com.path.pathfinder.graph.Vertex;

import java.util.*;

public class Algorithm {


    private final Graph graph;

    public Algorithm(Graph graph) {
        this.graph = graph;
    }

    public Set<Vertex> depthFirstTraversal(int root) {
        Set<Vertex> visited = new LinkedHashSet<>();
        Stack<Vertex> stack = new Stack<>();

        stack.add(graph.getVertex(root));

        while (!stack.isEmpty()) {

            Vertex currentVertex = stack.pop();

            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);


                for (Vertex v : graph.getNeighbours(currentVertex.getId())) {
                    stack.push(v);
                }
            }
        }

        return visited;

    }

    public Set<Vertex> depthFirstSearch(int root, int target) {
        Set<Vertex> visited = new LinkedHashSet<>();
        Stack<Vertex> stack = new Stack<>();

        stack.add(graph.getVertex(root));

        while (!stack.isEmpty()) {

            Vertex currentVertex = stack.pop();

            if (currentVertex.equals(new Vertex(target))) {
                visited.add(currentVertex);
                return visited;
            }

            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);


                for (Vertex v : graph.getNeighbours(currentVertex.getId())) {
                    stack.push(v);
                }
            }
        }

        return visited;

    }

    public Set<Vertex> breathFirstSearch(int root, int target) {

        Set<Vertex> visited = new LinkedHashSet<>();
        Queue<Vertex> queue = new LinkedList<>();


        queue.add(graph.getVertex(root));

        while (!queue.isEmpty()) {

            Vertex currentVertex = queue.poll();

            if (currentVertex.equals(new Vertex(target))) {
                visited.add(currentVertex);
                return visited;
            }

            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);


                for (Vertex v : graph.getNeighbours(currentVertex.getId())) {
                    queue.add(v);
                }
            }
        }

        return visited;

    }

    //TODO WRITE A TEST FOR THE PARENT CONNECTIONS
    public List<Vertex> findShortestPath(int root, int target) {
        List<Vertex> visited = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        int[] parent = new int[graph.getSize()];


        queue.add(graph.getVertex(root));
        parent[root] = -6;

        while (!queue.isEmpty()) {

            Vertex currentVertex = queue.poll();

            if (currentVertex.equals(new Vertex(target))) {
                return reconstructPath(parent, target);
            }

            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);


                for (Vertex v : graph.getNeighbours(currentVertex.getId())) {
                    queue.add(v);
                    if (!visited.contains(v)) {
                        parent[v.getId()] = currentVertex.getId();
                    }

                }
            }

        }
        return visited;
    }

    private List<Vertex> reconstructPath(int[] parent, int target) {
        List<Vertex> path = new ArrayList<>();

        while (target != -6) {
            path.add(graph.getVertex(target));
            target = parent[target];
        }

        Collections.reverse(path);
        return path;

    }

}
