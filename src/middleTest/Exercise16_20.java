package middleTest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_20 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Time time = new Time();
        Text text = new Text("00:00:00");

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), e -> {
                    time.increase();
                    text.setText(time.toString());
                }));
        animation.setCycleCount(Timeline.INDEFINITE);

        HBox hBox = new HBox(5);
        Button btStart = new Button("¿ªÊ¼");
        Button btClear = new Button("Çå³ý");
        hBox.getChildren().addAll(btStart, btClear);
        hBox.setAlignment(Pos.CENTER);

        btStart.setOnAction(e -> {
            if (btStart.getText().equals("¿ªÊ¼")) {
                btStart.setText("ÔÝÍ£");
                animation.play();
            } else if (btStart.getText().equals("ÔÝÍ£")) {
                btStart.setText("»Ö¸´");
                animation.pause();
            } else if (btStart.getText().equals("»Ö¸´")) {
                btStart.setText("ÔÝÍ£");
                animation.play();
            }
        });

        btClear.setOnAction(e -> {
            text.setText("00:00:00");
            animation.pause();
            btStart.setText("¿ªÊ¼");
        });

        text.setFont(Font.font("Times", 35));

        BorderPane pane = new BorderPane();
        pane.setBottom(hBox);
        pane.setCenter(text);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 100);
        primaryStage.setTitle("Exercise16_20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    static class Time {
        int value = 0;

        int getSecond() {
            return value % 60;
        }

        int getMinute() {
            return (value / 60) % 60;
        }

        int getHour() {
            return value / 3600;
        }

        void reset() {
            value = 0;
        }

        void increase() {
            value++;
        }

        @Override
        public String toString() {
            return getTwoDigitString(getHour()) + ":" + getTwoDigitString(getMinute())
                    + ":" + getTwoDigitString(getSecond());
        }

        static String getTwoDigitString(int v) {
            if (v < 10) {
                return "0" + v;
            } else {
                return "" + v;
            }
        }
    }
}
