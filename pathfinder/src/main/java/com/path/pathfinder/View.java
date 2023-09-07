package com.path.pathfinder;

import com.path.pathfinder.algorithms.Algorithm;
import com.path.pathfinder.components.ChoiceBoxComponent;
import com.path.pathfinder.graph.GraphBuilder;
import com.path.pathfinder.render.Render;
import com.path.pathfinder.util.DimensionData;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static com.path.pathfinder.util.UserInputData.*;

public class View extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        DimensionData dimensionData = new DimensionData(600, 600, 50, 50);
        Render r = new Render(dimensionData);
        GraphBuilder graphBuilder = new GraphBuilder(dimensionData);
        Algorithm algorithm = new Algorithm(graphBuilder.getGraph());

        r.addObserver(graphBuilder);

        Group group = new Group();
        group.setLayoutX(50);
        group.setLayoutY(50);
        group.getChildren().add(r.drawGrid());
        graphBuilder.buildGraph();

        ChoiceBoxComponent choiceBoxComponent = new ChoiceBoxComponent(r, algorithm, group, graphBuilder);

        group.getChildren().add(choiceBoxComponent.generateSelector());

        Scene scene = new Scene(group, 1100, 750);
        stage.setTitle("PathFinder");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}