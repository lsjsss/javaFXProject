package java_Book_Exercise14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise14_26 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(10);
        double paneWidth = 200;
        double paneHeight = 200;
        javaBook_JavaFX_Unit14_15_16.java14_21_ClockPane clock1 = new javaBook_JavaFX_Unit14_15_16.java14_21_ClockPane(4, 20, 45);
        clock1.setW(150);
        clock1.setH(150);
        javaBook_JavaFX_Unit14_15_16.java14_21_ClockPane clock2 = new javaBook_JavaFX_Unit14_15_16.java14_21_ClockPane(22, 46, 15);
        clock2.setW(150);
        clock2.setH(150);
        hBox.getChildren().addAll(clock1, clock2);
        // Create a scene and place it in the stage
        Scene scene = new Scene(hBox, paneWidth, paneHeight);
        primaryStage.setTitle("Exercise14_26"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
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
