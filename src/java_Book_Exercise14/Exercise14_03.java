package java_Book_Exercise14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Exercise14_03 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // There are two ways for shuffling. One is to use the hint in the book.
        // The other way is to use the static shuffle method in the java.util.Collections class.
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            list.add(i);
        }
        java.util.Collections.shuffle(list);
        HBox pane = new HBox(5);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(new ImageView("image/card/" + list.get(0) + ".png"));
        pane.getChildren().add(new ImageView("image/card/" + list.get(1) + ".png"));
        pane.getChildren().add(new ImageView("image/card/" + list.get(2) + ".png"));
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        // Set the stage title
        primaryStage.setTitle("Exercise14_03");
        // Place the scene in the stage
        primaryStage.setScene(scene);
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
