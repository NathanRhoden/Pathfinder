package com.path.pathfinder.algorithms;

import com.path.pathfinder.graph.Graph;
import com.path.pathfinder.graph.Vertex;

import java.util.*;

public class Algorithm {

    private Graph graph;

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

            if(currentVertex.equals(new Vertex(target))){
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

            if(currentVertex.equals(new Vertex(target))){
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
}
