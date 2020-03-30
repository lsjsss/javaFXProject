package javaclass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class java14_15_ShowLine extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new LinePain(), 200, 200);
        primaryStage.setTitle("ShowLine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class LinePain extends Pane {
    public LinePain() {
        Line line1 = new Line(10, 10, 10, 10);
        line1.endXProperty().bind(widthProperty().subtract(10));
        line1.endYProperty().bind(heightProperty().subtract(10));
        line1.setStrokeWidth(5);
        line1.setStroke(Color.GREEN);
        getChildren().add(line1);

        Line line2 = new Line(10, 10, 10, 10);
        //第二条线的起点
        line2.startXProperty().bind(widthProperty().subtract(10));
        //第二条线的终点
        line2.endYProperty().bind(heightProperty().subtract(10));
        line2.setStrokeWidth(5);
        line2.setStroke(Color.GREEN);
        getChildren().add(line2);

        Line line3 = new Line(10, 10, this.getWidth()+190, this.getHeight()+190);
        System.out.println(this.getWidth());
        line3.setStrokeWidth(5);
        line3.setStroke(Color.BLUE);
        getChildren().add(line3);
    }
}
