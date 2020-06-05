package java_Unit31;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class java31_02_Client extends Application {
    /**
     * IO 流
     */
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    /**
     * 覆盖 Application 类中的 start 方法
     */
    @Override
    public void start(Stage primaryStage) {
        // 面板 p 容纳标签和文本字段
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("输入半径: "));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);

        BorderPane mainPane = new BorderPane();
        // 显示内容的文字区域
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);

        // 创建一个场景并将其放置在舞台上
        Scene scene = new Scene(mainPane, 450, 200);
        // 设置舞台标题
        primaryStage.setTitle("java31_02_Client");
        // 将场景放置在舞台上
        primaryStage.setScene(scene);
        // 展示舞台
        primaryStage.show();

        tf.setOnAction(e -> {
            try {
                // 从文本字段获取半径
                double radius = Double.parseDouble(tf.getText().trim());

                // 将半径发送到服务器
                toServer.writeDouble(radius);
                // 清除流中的数据
                toServer.flush();

                // 从服务器获取区域
                double area = fromServer.readDouble();

                // 显示到文本区域
                ta.appendText("半径为 " + radius + "\n");
                ta.appendText("从服务器收到的面积是 " + area + '\n');
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });

        try {
            // 创建一个套接字以连接到服务器，127.0.0.1  指向本地机
            Socket socket = new Socket("localhost", 8000);
            // Socket socket = new Socket("130.254.204.36", 8000);
            // Socket socket = new Socket("drake.Armstrong.edu", 8000);

            // 创建输入流以从服务器接收数据
            fromServer = new DataInputStream(socket.getInputStream());

            // 创建输出流以将数据发送到服务器
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ta.appendText(ex.toString() + '\n');
        }
    }

    /**
     * 仅具有有限JavaFX支持的IDE才需要main方法。从命令行运行不需要。
     */
    public static void main(String[] args) {
        launch(args);
    }
}
