package java_Unit31;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class java31_01_Server extends Application {
    /** 覆盖Application类中的start方法 */
    @Override
    public void start(Stage primaryStage) {
        // 用于显示内容的文本区域
        TextArea ta = new TextArea();

        // 创建一个场景并将其放置在舞台上
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        // 设置舞台标题
        primaryStage.setTitle("java31_01_Server");
        // 将场景放置在舞台上
        primaryStage.setScene(scene);
        // 展示舞台
        primaryStage.show();

        new Thread(() -> {
            try {
                // 创建服务器套接字
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() ->
                        ta.appendText("java31_01_Server started at " + new Date() + '\n'));

                // 监听连接请求
                Socket socket = serverSocket.accept();

                // 创建数据输入和输出流
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());

                while (true) {
                    // 从客户端接收半径
                    double radius = inputFromClient.readDouble();

                    // 计算面积
                    double area = radius * radius * Math.PI;

                    // 将区域发送回客户
                    outputToClient.writeDouble(area);

                    Platform.runLater(() -> {
                        ta.appendText("Radius received from client: "
                                + radius + '\n');
                        ta.appendText("Area is: " + area + '\n');
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    /**
     * 仅具有有限JavaFX支持的IDE才需要main方法。从命令行运行不需要。
     */
    public static void main(String[] args) {
        launch(args);
    }
}
