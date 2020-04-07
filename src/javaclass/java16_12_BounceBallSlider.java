package javaclass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class java16_12_BounceBallSlider extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        java15_17_BallPane ballPane = new java15_17_BallPane();
        Slider slSpeed = new Slider();
        slSpeed.setMax(20);
        //属性绑定                              滑杆值属性
        ballPane.rateProperty().bind(slSpeed.valueProperty());

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(slSpeed);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("BounceBallSlider");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
