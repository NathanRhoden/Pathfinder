package com.path.pathfinder;

import com.path.pathfinder.graph.GraphBuilder;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class View extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        DimensionData dimensionData = new DimensionData(800, 800, 10, 10);

        GraphBuilder graphBuilder = new GraphBuilder(dimensionData);
        graphBuilder.buildGraph();
        graphBuilder.getGraph().showConnections();

        Render r = new Render(graphBuilder, dimensionData);
        Group group = new Group();
        group.getChildren().add(r.drawGrid());

        r.animate(0);


        Scene scene = new Scene(group, 800, 800);
        stage.setTitle("PathFinder");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}