module com.path.pathfinder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.path.pathfinder to javafx.fxml;
    exports com.path.pathfinder;
    exports com.path.pathfinder.render;
    opens com.path.pathfinder.render to javafx.fxml;
    exports com.path.pathfinder.algorithms;
    opens com.path.pathfinder.algorithms to javafx.fxml;
    exports com.path.pathfinder.util;
    opens com.path.pathfinder.util to javafx.fxml;
}