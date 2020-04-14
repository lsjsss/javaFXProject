package javaBook_JavaFX_Unit14_15_16;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class java15_16_ClockAnimation extends Application {
    @Override
    public void start(Stage primaryStage) {
        //创建一个时钟 形状
        java14_21_ClockPane_Tests clock = new java14_21_ClockPane_Tests();

        EventHandler<ActionEvent> eventHandler = e -> {
            clock.setCurrentTime();
        };

        Timeline animation = new Timeline(
                //周期：1000ms
                new KeyFrame(Duration.millis(1000), eventHandler));
        //设置动画循环次数                无限次循环
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(clock, 250, 250);
        primaryStage.setTitle("ClockAnimation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
