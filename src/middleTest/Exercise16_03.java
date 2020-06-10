package middleTest;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_03 extends Application {
    @Override
    public void start(Stage stage) {
        Rectangle rec = new Rectangle(115, 10, 70, 200);
        rec.setStroke(Color.BLACK);
        rec.setFill(Color.WHITE);

        Circle c1 = new Circle(150, 45, 30, Color.WHITE);
        Circle c2 = new Circle(150, 110, 30, Color.WHITE);
        Circle c3 = new Circle(150, 175, 30, Color.WHITE);
        c1.setStroke(Color.BLACK);
        c2.setStroke(Color.BLACK);
        c3.setStroke(Color.BLACK);

        RadioButton rb1 = new RadioButton();
        RadioButton rb2 = new RadioButton();
        RadioButton rb3 = new RadioButton();

        ToggleGroup tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        rb1.setSelected(true);

        rb1.setOnMouseClicked(e -> {
            c1.setFill(Color.RED);
            c1.setStroke(Color.WHITE);
            c2.setFill(Color.WHITE);
            c3.setFill(Color.WHITE);
            c2.setStroke(Color.BLACK);
            c3.setStroke(Color.BLACK);
        });
        rb2.setOnMouseClicked(e -> {
            c2.setFill(Color.YELLOW);
            c2.setStroke(Color.WHITE);
            c1.setFill(Color.WHITE);
            c3.setFill(Color.WHITE);
            c1.setStroke(Color.BLACK);
            c3.setStroke(Color.BLACK);
        });
        rb3.setOnMouseClicked(e -> {
            c3.setFill(Color.GREEN);
            c3.setStroke(Color.WHITE);
            c2.setFill(Color.WHITE);
            c1.setFill(Color.WHITE);
            c2.setStroke(Color.BLACK);
            c1.setStroke(Color.BLACK);
        });

        Text t1 = new Text("Red");
        Text t2 = new Text("Yellow");
        Text t3 = new Text("Green");

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(rb1, t1, rb2, t2, rb3, t3);

        Pane pa = new Pane();
        pa.getChildren().addAll(rec, c1, c2, c3);

        BorderPane pane = new BorderPane();
        pane.setCenter(pa);
        pane.setBottom(hbox);
        Scene scene = new Scene(pane, 300, 250);
        stage.setTitle("Exercise16_03");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
