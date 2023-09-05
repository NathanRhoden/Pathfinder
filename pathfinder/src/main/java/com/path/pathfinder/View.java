package com.path.pathfinder;

import com.path.pathfinder.algorithms.Algorithm;
import com.path.pathfinder.graph.Graph;
import com.path.pathfinder.graph.GraphBuilder;
import com.path.pathfinder.render.Render;
import com.path.pathfinder.util.DimensionData;
import com.path.pathfinder.util.VertexList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        DimensionData dimensionData = new DimensionData(600, 600, 50, 50);
        Render r = new Render(dimensionData , new Pane());

        GraphBuilder graphBuilder = new GraphBuilder(dimensionData);
        Group group = new Group();
        group.getChildren().add(r.drawGrid());
        graphBuilder.buildGraph();

        r.addObserver(graphBuilder);


        Button button = new Button("Click me");
        button.setLayoutX(900);
        button.setLayoutY(900);
        button.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Graph g = graphBuilder.getGraph();
                        g.showConnections();
                        Algorithm algorithm = new Algorithm(g);
                        r.animateSearch(algorithm.breathFirstSearch(0,2499) ,2499);
                        //r.animate(algorithm.findShortestPath(0 , 2499) ,2499);
                    }
                }
        );

        group.getChildren().add(button);



        Scene scene = new Scene(group, 1000, 1000);
        stage.setTitle("PathFinder");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}