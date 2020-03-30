package javaclass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class java15_01_HandleEvent extends Application {
    @Override
    public void start(Stage primaryStage) {
        //面板水平盒子  从左到右排列
        HBox pane = new HBox(10);
        //Pos设置面板位置关系  对齐方式：水平垂直居中  CENTER:居中对齐
        pane.setAlignment(Pos.CENTER);
        /*可以获取帮助信息
         * 指向要获取信息的地方， 稍停
         * 提示信息窗口可以滚动
         * 还可以打开JavaDoc
         */

        Button btOK = new Button("OK");
        Button btCancel = new Button("Cancel");

        //创建一个事件处理器  监听器类(OKHandelClass)
        OKHandlerClass handler1 = new OKHandlerClass();
        //让事件处理器监听到按钮：注册
        btOK.setOnAction(handler1);

        //给取消按钮 btCancel 设置监听器 haleer2
        CancelHandlerClass handler2 = new CancelHandlerClass();

        //额外  事件处理器(监听器 / 事件监听器)  把 OK 按钮和 Cancel 按钮一起放到面板上
        btCancel.setOnAction(handler2);
        pane.getChildren().addAll(btOK,btCancel);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("HandleEvent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

/**监听器类  实现一个接口(监听器接口)：EventHandler*/
class OKHandlerClass implements EventHandler<ActionEvent> {
    @Override
    //重写 handle 方法
    public void handle(ActionEvent e) {
        //事件发生之后，处理结果
        System.out.println("OK button clicked");
    }
}

class CancelHandlerClass implements  EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Cancel button clicked");
    }
}

/**事件驱动编程步骤：
 * 1.创建一个监听器对象；
 * 2.注册监听器： 事件源.setOnAction(监听器)
 * 3.编写监听器类； implements EventHandler<ActionEvent>
 * 4.重写 handle() 方法
 * 5.事件发生后要执行的代码编到这个方法中。
 * */