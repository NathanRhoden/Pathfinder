package com.path.pathfinder;

import com.path.pathfinder.graph.Graph;
import com.path.pathfinder.graph.Vertex;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Graph g = new Graph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);

        g.showConnection();

        Group group = new Group();

        Scene scene = new Scene(group, 800, 800);
        stage.setTitle("PathFinder");
        stage.setScene(scene);
        //stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}