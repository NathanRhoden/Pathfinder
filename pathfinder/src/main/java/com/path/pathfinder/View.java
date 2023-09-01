package com.path.pathfinder;

import com.path.pathfinder.graph.Graph;
import com.path.pathfinder.graph.GraphBuilder;
import com.path.pathfinder.graph.Vertex;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GraphBuilder graphBuilder = new GraphBuilder(5 , 5);
        graphBuilder.buildGraph();
        graphBuilder.getGraph().showConnection();


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