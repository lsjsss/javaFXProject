package javaclass;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/** 复选框， 继承原面板（ ButtonDemo ）(按钮演示) */
public class java16_3_CheckBoxDemo extends java16_2_ButtonDemo {
    @Override
    /** 本类中有属性，为继承于 ButtonDemo 中的 text 属性 */
    protected BorderPane getPane(){
        //代码重用， 调用父类的面板
        BorderPane pane = super.getPane();
        //字体加粗和倾斜效果
        Font fontBoldItalic = Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture. ITALIC, 20);
        //字体正常加粗效果
        Font fontBold = Font.font("Times New Roman",
                FontWeight.BOLD, FontPosture. REGULAR, 20);
        //字体倾斜效果
        Font fontItalic = Font.font("Times New Roman",
                FontWeight.NORMAL, FontPosture. ITALIC, 20);
        //字体既不加粗也不倾斜
        Font fontNormal = Font. font("Times New Roman",
                FontWeight.NORMAL, FontPosture. REGULAR, 20);


        text.setFont(fontNormal);

        //设置一个新面板 (复选框按钮)
        VBox paneForCheckBoxes = new VBox(20);
        paneForCheckBoxes.setPadding(new Insets(5,5,5,5));
        paneForCheckBoxes.setStyle("-fx-borde-: green");
        //创建两个复选框 - 加粗
        CheckBox chkBold = new CheckBox("Bold");
        // - 倾斜
        CheckBox chkItalic = new CheckBox("Italic");
        //添加到面板上
        paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
        //添加到大面板右侧
        pane.setRight(paneForCheckBoxes);

        //lambda 表达式
        EventHandler<ActionEvent> handler = e -> {
            //如果两复选框(加粗)都被选中
            if (chkBold.isSelected() && chkItalic.isSelected()) {
                text.setFont(fontBoldItalic);
            } else if (chkBold.isSelected()) {//加粗被选中
                text.setFont(fontBold);
            } else if (chkItalic.isSelected()) {//倾斜被选中
                text.setFont(fontItalic);
            } else {//两个复选按钮都没有被选中
                text.setFont(fontNormal);
            }
        };

        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);
        return pane;
    }
}
