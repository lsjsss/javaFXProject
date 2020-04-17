package javaAdvanceHomework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class java_Unit17_Contacts extends Application {
    @Override
    public void start(Stage primaryStage) {

        GridPane gridpane = new GridPane();

        Button bt_add = new Button("Add");
        Button bt_first = new Button("First");
        Button bt_next = new Button("Next");
        Button bt_previous = new Button("Previous");
        Button bt_last = new Button("Last");
        Button bt_update = new Button("Update");

        Pane pane = new Pane();
        pane.getChildren().add(bt_add);



        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Contacts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
