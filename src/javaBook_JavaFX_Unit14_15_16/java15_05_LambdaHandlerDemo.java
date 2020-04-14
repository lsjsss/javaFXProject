package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class java15_05_LambdaHandlerDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        //新建new按钮
        Button btNew = new Button("New");
        Button btOpen = new Button("Open");
        Button btSave = new Button("Save");
        Button btPrint = new Button("Print");
        hBox.getChildren().addAll(btNew, btOpen, btSave, btPrint);

        //lambda 表达式的使用， 简化匿名内部类，使用 lambda 函数来编写事件驱动程序
        //lambda 函数是最简化的形式
        //理解编译器是如何处理的
        btNew.setOnAction((ActionEvent e) -> {
            System.out.println("Process New");
        });

        //没有指出参数类型
        btOpen.setOnAction((e) -> {
            System.out.println("Process Open");
        });

        btSave.setOnAction((e) -> {
            System.out.println("Process Save");
        });

        //lambda表达式最简
        btPrint.setOnAction(e -> System.out.println("Process Print"));

        Scene scene = new Scene(hBox, 300, 50);
        primaryStage.setTitle("LambdaHandlerDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
