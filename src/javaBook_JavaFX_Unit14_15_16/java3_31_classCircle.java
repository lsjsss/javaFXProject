package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class java3_31_classCircle extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lb = new Label("圆", new Circle(70, 70, 25));
        lb.setContentDisplay(ContentDisplay.RIGHT);
        lb.setTextFill(Color.RED);

        HBox pane = new HBox(50);
        pane.getChildren().add(lb);

        Scene scene = new Scene(pane, 200, 70);
        primaryStage.setTitle("圆");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
