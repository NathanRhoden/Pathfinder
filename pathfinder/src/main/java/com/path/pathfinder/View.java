package com.path.pathfinder;

import com.path.pathfinder.algorithms.Algorithm;
import com.path.pathfinder.graph.GraphBuilder;
import com.path.pathfinder.render.Render;
import com.path.pathfinder.util.DimensionData;
import com.path.pathfinder.util.UserInputData;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.path.pathfinder.util.UserInputData.*;

public class View extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        DimensionData dimensionData = new DimensionData(600, 600, 50, 50);
        Render r = new Render(dimensionData);

        GraphBuilder graphBuilder = new GraphBuilder(dimensionData);
        Group group = new Group();
        group.getChildren().add(r.drawGrid());
        graphBuilder.buildGraph();

        Algorithm algorithm = new Algorithm(graphBuilder.getGraph());

        Button resetButton = new Button("Reset");
        resetButton.setLayoutY(650);
        resetButton.setLayoutX(650);
        group.getChildren().add(resetButton);

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

        r.addObserver(graphBuilder);
        ChoiceBox<String> functionChoice = new ChoiceBox<>();

        functionChoice.getItems().add("BFS");
        functionChoice.getItems().add("DFS");
        functionChoice.getItems().add("BFS - Shortest Path");
        functionChoice.setPrefWidth(100);
        Label label = new Label("Algorithm : ");
        Button runButton = new Button("Run");

        runButton.setOnAction(event -> {
            if (functionChoice.getValue().equals("BFS")) {
                r.animateSearch(algorithm.breathFirstSearch(ROOT, TARGET), TARGET);
            } else if (functionChoice.getValue().equals("DFS")) {
                r.animateSearch(algorithm.depthFirstSearch(ROOT, TARGET), TARGET);
            } else if (functionChoice.getValue().equals("BFS - Shortest Path")) {
                r.animate(algorithm.findShortestPath(ROOT, TARGET), TARGET);
            }
            event.consume();
        });

        HBox hbox = new HBox(
                label,
                functionChoice,
                runButton
        );


        hbox.setSpacing(10.0d);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(40));
        hbox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
        hbox.setLayoutX(650);
        hbox.setLayoutY(400);

        group.getChildren().add(hbox);

        Scene scene = new Scene(group, 1000, 800);
        stage.setTitle("PathFinder");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}