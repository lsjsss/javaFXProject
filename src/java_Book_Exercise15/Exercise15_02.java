package java_Book_Exercise15;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Exercise15_02 extends Application {
    private double angle = 0;

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox(10);
        pane.setPadding(new Insets(20, 20, 20, 20));
        Rectangle re = new Rectangle(50,50,20,40);
        re.setFill(Color.WHITE);
        re.setStroke(Color.BLACK);
        Button btRotate = new Button("Rotate");
        pane.getChildren().addAll(re, btRotate);
        pane.setAlignment(Pos.CENTER);
        btRotate.setOnAction(e -> {
            changeRectangle(re);
        });
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Ðý×ª¾ØÐÎ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeRectangle(Rectangle re) {
        angle += 15;
        re.setRotate(angle);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }
}
