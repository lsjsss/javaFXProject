package javaclass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class java16_11_SliderDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Text text = new Text(20, 20, "JavaFX programming");

        Slider slHorizontal = new Slider();
        //设置带有刻度的滚动条
        slHorizontal.setShowTickLabels(true);
        slHorizontal.setShowTickMarks(true);

        Slider slVertical = new Slider();
        slHorizontal.setShowTickLabels(false);
        slHorizontal.setShowTickMarks(true);
        slVertical.setValue(100);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);

        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setBottom(slHorizontal);
        pane.setRight(slVertical);

        slHorizontal.valueProperty().addListener(ov ->
                text.setX(slHorizontal.getValue() * paneForText.getWidth() / slHorizontal.getMax()));

        slVertical.valueProperty().addListener(ov ->
                text.setY((slVertical.getMax() - slVertical.getValue()) * paneForText.getHeight() / slVertical.getValue()));

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("SliderDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
