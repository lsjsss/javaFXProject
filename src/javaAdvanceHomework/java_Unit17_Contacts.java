package javaAdvanceHomework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class java_Unit17_Contacts extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button b1 = new Button("Next");

        Pane pane = new Pane();
        pane.getChildren().add(b1);
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Contacts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
