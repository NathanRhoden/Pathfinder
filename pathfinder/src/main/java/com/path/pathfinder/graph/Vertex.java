package com.path.pathfinder.graph;

import java.util.Objects;

public class Vertex {

    private final int id;

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return getId() == vertex.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Vertex {" + id +
                '}';
    }
}
