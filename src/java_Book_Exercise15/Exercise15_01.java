package java_Book_Exercise15;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;

import java.util.*;

public class Exercise15_01 extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox(5);
        pane.setPadding(new Insets(5, 5, 5, 5));
        Cardspane cards = new Cardspane();
        pane.getChildren().add(cards);
        Button btRefresh = new Button("Refresh");
        pane.getChildren().add(btRefresh);
        pane.setAlignment(Pos.CENTER);
        VBox.setMargin(btRefresh, new Insets(5, 5, 5, 5));
        btRefresh.setOnAction(e -> {
            cards.refresh();
        });
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Exercise15_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Cardspane extends HBox {
        private Integer[] cardsNum = {1, 2, 3, 4, 5, 6, 7, 8, 9
                , 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 120, 21, 22
                , 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35,
                36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50
                , 51, 52, 53, 54
        };
        private ArrayList<Integer> list = new ArrayList<>(Arrays.asList(cardsNum));
        private ImageView p1;
        private ImageView p2;
        private ImageView p3;
        private ImageView p4;

        public void CardsPane() {
            setSpacing(5);
            Collections.shuffle(list);
            p1 = new ImageView("image/card/" + Integer.valueOf(list.get(0)) + ".png");
            p2 = new ImageView("image/card/" + Integer.valueOf(list.get(1)) + ".png");
            p3 = new ImageView("image/card/" + Integer.valueOf(list.get(2)) + ".png");
            p4 = new ImageView("image/card/" + Integer.valueOf(list.get(3)) + ".png");
            super.getChildren().addAll(p1, p2, p3, p4);
        }

        public void refresh() {
            Collections.shuffle(list);
            super.getChildren().removeAll(p1, p2, p3, p4);
            p1 = new ImageView("image/card/" + Integer.valueOf(list.get(0)) + ".png");
            p2 = new ImageView("image/card/" + Integer.valueOf(list.get(1)) + ".png");
            p3 = new ImageView("image/card/" + Integer.valueOf(list.get(2)) + ".png");
            p4 = new ImageView("image/card/" + Integer.valueOf(list.get(3)) + ".png");
            super.getChildren().addAll(p1, p2, p3, p4);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }
}
