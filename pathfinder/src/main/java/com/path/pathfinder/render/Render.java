package com.path.pathfinder.render;

import com.path.pathfinder.graph.Observer;
import com.path.pathfinder.graph.Vertex;
import com.path.pathfinder.util.DimensionData;
import javafx.animation.FillTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.path.pathfinder.util.UserInputData.*;

public class Render {

    Rectangle[] vertexList;
    DimensionData dimensionData;
    List<Observer> observers = new ArrayList<>();
    int removed;


    public Render(DimensionData dimensionData) {
        vertexList = new Rectangle[dimensionData.getCol() * dimensionData.getRow()];
        this.dimensionData = dimensionData;
    }


    public Pane drawGrid() {
        Pane pane = new Pane();
        pane.setOnDragDetected(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                event.consume();
                pane.startFullDrag();
            }
        });


        int w = dimensionData.getRectangleWidth();
        int h = dimensionData.getRectangleHeight();

        int y = 0;
        int count = 0;

        for (int i = 0; i < dimensionData.getCol(); i++) {

            int x = 0;

            for (int j = 0; j < dimensionData.getRow(); j++) {
                Rectangle r = new Rectangle(x, y, w, h);

                r.setOnMouseClicked(mouseEvent -> {
                    if (mouseEvent.getButton() == MouseButton.SECONDARY) {

                        for (int k = 0; k < vertexList.length; k++) {

                            if (vertexList[k] == r) {
                                if (LASTCLICKEDNODES[1] == -1) {
                                    r.setStroke(Color.BLACK);
                                    r.setFill(Color.RED);

                                    TARGET = k;
                                    LASTCLICKEDNODES[1] = k;
                                    System.out.println(LASTCLICKEDNODES[1]);
                                }

                            }
                        }


                        mouseEvent.consume();
                    }
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {


                        for (int k = 0; k < vertexList.length; k++) {

                            if (vertexList[k] == r) {
                                if (LASTCLICKEDNODES[0] == -1) {
                                    r.setStroke(Color.BLACK);
                                    r.setFill(Color.GREEN);

                                    ROOT = k;
                                    LASTCLICKEDNODES[0] = k;
                                    System.out.println(LASTCLICKEDNODES[0]);
                                }

                            }
                        }
                        mouseEvent.consume();
                    }

                });


                r.setOnMouseDragEntered(event -> {

                    for (int k = 0; k < vertexList.length; k++) {
                        if (vertexList[k] == r) {
                            if (LASTCLICKEDNODES[0] != k && LASTCLICKEDNODES[1] != k) {
                                r.setFill(Color.BLACK);
                                updateRemovedVertex(k);
                            }

                        }
                    }
                });
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

    public void fillRect(int vertexIndex, Color color) {
        vertexList[vertexIndex].setFill(color);
    }

    public void animate(Set<Vertex> vertexOrderSet) {
        SequentialTransition st = new SequentialTransition();
        st.setRate(100);
        vertexOrderSet.forEach(v -> {
            FillTransition ft = new FillTransition();
            ft.setShape(vertexList[v.getId()]);
            ft.setToValue(Color.DARKORANGE);
            st.getChildren().add(ft);
        });

        st.play();
    }

    public void animate(List<Vertex> vertexOrderSet, int end) {
        SequentialTransition st = new SequentialTransition();
        st.setRate(50);

        final int[] k = {0};

        vertexOrderSet.forEach(v -> {
            if (v.getId() == end) {
                FillTransition ft = new FillTransition();
                ft.setShape(vertexList[v.getId()]);
                ft.setToValue(Color.RED);
                st.getChildren().add(ft);

            } else {
                FillTransition ft = new FillTransition();
                ft.setShape(vertexList[v.getId()]);
                ft.setToValue(Color.RED);
                st.getChildren().add(ft);
                k[0]++;
            }

        });

        st.play();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void updateRemovedVertex(int id) {
        removed = id;
        for (Observer o : this.observers) {
            o.update(removed);
        }
    }

    public void animateSearch(Set<Vertex> vertexOrderSet, int end) {
        SequentialTransition st = new SequentialTransition();
        st.setRate(500);

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
                } else if (k[0] > 0.25 * x && k[0] <= 0.50 * x) {
                    ft.setToValue(Color.rgb(199, 0, 57));
                } else if (k[0] > 0.50 * x && k[0] <= 0.75 * x) {
                    ft.setToValue(Color.rgb(249, 76, 16));
                } else {
                    ft.setToValue(Color.rgb(248, 222, 34));
                }
                st.getChildren().add(ft);
                k[0]++;

            }

        });
        st.play();
    }

}
