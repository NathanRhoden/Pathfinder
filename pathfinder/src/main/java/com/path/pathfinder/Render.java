package com.path.pathfinder;

import com.path.pathfinder.graph.GraphBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
}
