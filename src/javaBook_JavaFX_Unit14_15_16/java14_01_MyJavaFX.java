package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class java14_01_MyJavaFX extends Application {
     @Override
     public void start(Stage primaryStage){
         Button btOK = new Button("OK");
         Scene scene = new Scene(btOK, 200, 250);
         primaryStage.setTitle("MyJavaFX");
         primaryStage.setScene(scene);
         primaryStage.show();
     }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


