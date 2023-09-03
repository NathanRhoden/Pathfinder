package com.path.pathfinder;

import com.path.pathfinder.algorithms.Algorithm;
import com.path.pathfinder.graph.Graph;
import com.path.pathfinder.graph.GraphBuilder;
import com.path.pathfinder.render.Render;
import com.path.pathfinder.util.DimensionData;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        DimensionData dimensionData = new DimensionData(800, 800, 50, 50);

        GraphBuilder graphBuilder = new GraphBuilder(dimensionData);
        graphBuilder.buildGraph();
        Graph g = graphBuilder.getGraph();

        Render r = new Render(graphBuilder, dimensionData);
        Group group = new Group();
        group.getChildren().add(r.drawGrid());

        Algorithm algorithm = new Algorithm(g);
        r.animateSearch(algorithm.breathFirstSearch(200, 0), 0);

        Scene scene = new Scene(group, 800, 800);
        stage.setTitle("PathFinder");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}