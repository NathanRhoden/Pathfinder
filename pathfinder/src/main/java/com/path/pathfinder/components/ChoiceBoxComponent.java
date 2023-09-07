package com.path.pathfinder.components;

import com.path.pathfinder.algorithms.Algorithm;
import com.path.pathfinder.graph.GraphBuilder;
import com.path.pathfinder.render.Render;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import static com.path.pathfinder.util.UserInputData.*;
import static com.path.pathfinder.util.UserInputData.LASTCLICKEDNODES;

public class ChoiceBoxComponent {

    ChoiceBox<String> choiceBox;
    Label label;
    Render r;
    Algorithm a;
    Group group;
    GraphBuilder graphBuilder;


    public ChoiceBoxComponent(Render r, Algorithm a, Group group, GraphBuilder graphBuilder) {
        this.r = r;
        this.a = a;
        this.group = group;
        this.graphBuilder = graphBuilder;
        label = new Label("Algorithm");
        choiceBox = new ChoiceBox<>();

    }


    public ChoiceBox<String> initChoiceBox() {

        choiceBox.getItems().addAll("BFS", "DFS", "BFS - Shortest Path");
        choiceBox.getSelectionModel().selectFirst();

        choiceBox.setPrefWidth(100);

        return choiceBox;
    }

    public Label label() {
        return label;
    }

    public Button runButton() {
        Button runButton = new Button("Run");

        runButton.setOnAction(event -> {
            if (choiceBox.getValue().equals("BFS")) {
                r.animateSearch(a.breathFirstSearch(ROOT, TARGET), TARGET);
            } else if (choiceBox.getValue().equals("DFS")) {
                r.animateSearch(a.depthFirstSearch(ROOT, TARGET), TARGET);
            } else if (choiceBox.getValue().equals("BFS - Shortest Path")) {
                r.animate(a.findShortestPath(ROOT, TARGET), TARGET);
            }
            event.consume();
        });

        return runButton;
    }

    public Button resetButton() {
        Button resetButton = new Button("Reset");
        resetButton.setLayoutY(350);
        resetButton.setLayoutX(800);
        resetButton.setPrefWidth(50);

        resetButton.setOnAction(
                event -> {
                    group.getChildren().remove(r);
                    graphBuilder.resetGraph();
                    group.getChildren().add(r.drawGrid());
                    LASTCLICKEDNODES[0] = -1;
                    LASTCLICKEDNODES[1] = -1;
                    ROOT = 0;
                    TARGET = 0;
                }
        );

        return resetButton;

    }

    public HBox generateSelector() {
        HBox hBox = new HBox(
                label(),
                initChoiceBox(),
                runButton(),
                resetButton()
        );

        hBox.setSpacing(10.0d);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(40));
        hBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        hBox.setLayoutX(650);
        hBox.setLayoutY(250);

        return hBox;


    }


}
