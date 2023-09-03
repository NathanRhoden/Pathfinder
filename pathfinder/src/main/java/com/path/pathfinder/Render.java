package com.path.pathfinder;

import com.path.pathfinder.graph.GraphBuilder;
import com.path.pathfinder.graph.Vertex;
import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.*;

public class Render {

    GraphBuilder builder;
    Rectangle[] vertexList;
    DimensionData dimensionData;

    public Render(GraphBuilder builder, DimensionData dimensionData) {

        this.builder = builder;
        vertexList = new Rectangle[dimensionData.getCol() * dimensionData.getRow()];
        this.dimensionData = dimensionData;
    }

    public Pane drawGrid() {
        Pane pane = new Pane();
        int w = dimensionData.getRectangleWidth();
        int h = dimensionData.getRectangleHeight();

        int y = 0;
        int count = 0;

        for (int i = 0; i < dimensionData.getCol(); i++) {

            int x = 0;

            for (int j = 0; j < dimensionData.getRow(); j++) {
                Rectangle r = new Rectangle(x, y, w, h);
                r.setStroke(Color.BLACK);
                r.setFill(Color.WHITE);
                pane.getChildren().add(r);
                vertexList[count] = r;

                x += w;
                count++;

            }
            y += h;
        }

        return pane;
    }

    public Rectangle[] getVertexList() {
        return vertexList;
    }

    public GraphBuilder getBuilder() {
        return builder;
    }

    public void fillRect(int vertexIndex, Color color) {
        vertexList[vertexIndex].setFill(color);
    }


    /*
        FillTransition ft = new FillTransition(Duration.millis(1000));
        ft.setShape(vertexList[root]);
        ft.setToValue(Color.RED);
        ft.setCycleCount(1);
         */

    /*
    WORKING------------------
    var order = depthFirstTraversal(6);
        SequentialTransition st = new SequentialTransition();

        order.forEach(e -> {
            FillTransition ft = new FillTransition();
            ft.setShape(vertexList[e.getId()]);
            ft.setToValue(Color.ORANGERED);
            st.getChildren().add(ft);
        });

        st.play();
     */
    public void animate(int root) {
        var order = depthFirstTraversal(root);
        SequentialTransition st = new SequentialTransition();

        order.forEach(e -> {
            FillTransition ft = new FillTransition();
            ft.setShape(vertexList[e.getId()]);
            ft.setToValue(Color.ORANGERED);
            st.getChildren().add(ft);
        });

        st.play();

    }


    public Set<Vertex> depthFirstTraversal(int root) {
        Set<Vertex> visited = new LinkedHashSet<>();
        Stack<Vertex> stack = new Stack<>();


        stack.add(builder.getGraph().getVertex(root));

        while (!stack.isEmpty()) {

            Vertex currentVertex = stack.pop();

            if (!visited.contains(currentVertex)) {
                visited.add(currentVertex);


                for (Vertex v : builder.getGraph().getNeighbours(currentVertex.getId())) {
                    stack.push(v);
                }
            }
        }

        return visited;

    }


}
