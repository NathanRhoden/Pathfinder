package com.path.pathfinder.util;

import java.util.ArrayList;
import java.util.List;

public class VertexList {

    static List<Integer> removedVertex = new ArrayList<>();


    public static List<Integer> getRemovedVertex() {
        return removedVertex;
    }

    public static void addRemovedVertex(int vertexId){
        removedVertex.add(vertexId);
        System.out.println(vertexId);
    }

}

