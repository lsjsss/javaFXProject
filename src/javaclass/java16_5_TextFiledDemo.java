package javaclass;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class java16_5_TextFiledDemo extends java16_4_RadioButtonDemo {
    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();
        //边界面板不一定在各区域都放置 node
        //放置文本与
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color: green");
        //信息
        paneForTextField.setLeft(new Label("Enter a new message: "));

        //文本域
        TextField tf = new TextField();
        //设置文本域对齐方式： 右对齐
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        //将面板放到中间
        paneForTextField.setCenter(tf);
        //将面板放到顶端
        pane.setTop(paneForTextField);

        // * 监听文本框：在文本域中输入文本后按下回车键，动作事件发生
        tf.setOnAction(e -> text.setText(tf.getText()));

        return pane;
    }

}
