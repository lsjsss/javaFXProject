package javaclass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class java15_08_KeyEventDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text text = new Text(20, 20, "A");

        pane.getChildren().add(text);
        //键盘事件  事件源 text KeyPressed 事件(键盘上的键按下)， Type(按下去又弹起来(松开))
        text.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                //按下键盘下键，向下移动10个像素
                case DOWN: text.setY(text.getY() + 10); break;
                case UP: text.setY(text.getY() - 10); break;
                case LEFT: text.setX(text.getX() - 10); break;
                case RIGHT: text.setX(text.getX() + 10); break;
                //如果按下的不是方向键
                default:
                    //获取键盘上的字符，显示到text里
                    if (Character.isLetterOrDigit(e.getText().charAt(0))){
                        text.setText(e.getText());
                    }
            }
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("KeyEventDemo");
        primaryStage.setScene(scene);
        primaryStage.show();

        //每次事件发生之后，需要把文本重新设置为焦点
        text.requestFocus();
    }
}
