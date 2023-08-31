module com.path.pathfinder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.path.pathfinder to javafx.fxml;
    exports com.path.pathfinder;
}