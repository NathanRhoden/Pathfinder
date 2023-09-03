package com.path.pathfinder.render;

import com.path.pathfinder.util.DimensionData;
import com.path.pathfinder.graph.GraphBuilder;
import com.path.pathfinder.graph.Vertex;
import javafx.animation.FillTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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

    public void animate(Set<Vertex> vertexOrderSet) {
        SequentialTransition st = new SequentialTransition();

        vertexOrderSet.forEach(v -> {
            FillTransition ft = new FillTransition();
            ft.setShape(vertexList[v.getId()]);
            ft.setToValue(Color.DARKORANGE);
            st.getChildren().add(ft);
        });

        st.play();
    }

    public void animateSearch(Set<Vertex> vertexOrderSet, int end) {
        SequentialTransition st = new SequentialTransition();
        st.setRate(10);

        final int x = vertexOrderSet.size();
        final int[] k = {0};

        vertexOrderSet.forEach(v -> {
            if (v.getId() == end) {
                FillTransition ft = new FillTransition();
                ft.setShape(vertexList[v.getId()]);
                ft.setToValue(Color.INDIANRED);
                st.getChildren().add(ft);

            } else {
                FillTransition ft = new FillTransition();
                ft.setShape(vertexList[v.getId()]);
                if (k[0] <= 0.25 * x) {
                    ft.setToValue(Color.rgb(144, 12, 63));
                }
                else if (k[0] > 0.25 * x && k[0] <= 0.50 * x){
                    ft.setToValue(Color.rgb(199, 0, 57));
                }
                else if(k[0] > 0.50 * x && k[0] <= 0.75 * x){
                    ft.setToValue(Color.rgb(249, 76, 16));
                }
                else {
                    ft.setToValue(Color.rgb(248, 222, 34));
                }
                st.getChildren().add(ft);
                k[0]++;

            }

        });
        st.play();
    }


}
