package javaclass;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class java14_14_ShowText extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        //设置文本位置
        Text text1 = new Text(20, 20, "Programming is fun");
        //字体，加粗，倾斜，字体大小15
        text1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
        pane.getChildren().add(text1);

        //第二个文本框
        Text text2 = new Text(60, 60, "Programming is fun\nDisplay text");
        pane.getChildren().add(text2);

        //显示两行文本
        Text text3 = new Text(10, 100, "Programming is fun\nDisplay text");
        text3.setFill(Color.RED);
        //下划线
        text3.setUnderline(true);
        //删除线
        text3.setStrikethrough(true);
        pane.getChildren().add(text3);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowText");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
