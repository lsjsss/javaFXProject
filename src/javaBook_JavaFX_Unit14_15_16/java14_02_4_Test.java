package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.stage.Stage;

public class java14_02_4_Test extends Application {  //继承
    public java14_02_4_Test() {
        System.out.println("Test constructor is invoked");
    }

    @Override
    public void start(Stage primaryStage) {  //主舞台
        System.out.println("start methood is invoked");
    }

    public static void main(String[] args) {
        System.out.println("launch application");
        Application.launch(args);
    }
}
