package sybg1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * 基于TCP协议的聊天室程序 服务器端
 * @author lsjss
 */
public class Server extends Application {
    /**
     * 用于显示内容的文本区域
     */
    private TextArea ta = new TextArea();

    /**
     * 套接字到输出流的映射
     */
    private Hashtable outputStreams = new Hashtable();

    /**
     * 服务器插座
     */
    private ServerSocket serverSocket;

    TextField text = new TextField();

    /**
     * 覆盖Application类中的start方法
     */
    @Override
    public void start(Stage primaryStage) {
        ServerUI(primaryStage);
    }

    private void ServerUI(Stage primaryStage) {
        ta.setWrapText(true);

        HBox hBox = new HBox();

        Button send = new Button("发送信息");
        Button start = new Button("启动服务");

        hBox.getChildren().addAll(text, send, start);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(new ScrollPane(ta), hBox);

        text.setOnAction(e -> {
            sendToAll("server>>" + text.getText());
            ta.appendText("server>>" + text.getText() + "\n");
        });
        send.setOnAction(e -> {
            sendToAll("server>>" + text.getText());
            ta.appendText("server>>" + text.getText() + "\n");
        });


        start.setOnAction(e -> new Thread(() -> ListenerClient()).start());

        // 创建一个场景并将其放置在舞台上
        Scene scene = new Scene(vBox, 520, 220);
        // 设置舞台标题
        primaryStage.setTitle("TCPServer");
        // 将场景放置在舞台上
        primaryStage.setScene(scene);
        // 展示舞台
        primaryStage.show();
    }

    private void ListenerClient() {
        try {
            // 创建服务器套接字
            serverSocket = new ServerSocket(8000);
            Platform.runLater(() ->
                    ta.appendText("启动服务成功：端口" + serverSocket.getLocalPort() + '\n' + "等待客户端" + '\n'));

            while (true) {
                // 收听新的连接请求
                Socket socket = serverSocket.accept();

                // 显示客户编号
                Platform.runLater(() ->
                        ta.appendText("连接成功 " + socket + '\n' + "等待客户端" + '\n'));

                // 创建输出流
                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

                // 将输出流保存到哈希表
                outputStreams.put(socket, dout);

                // 为连接创建一个新线程
                new CliectThread(this, socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 用于获取输出流
     */
    Enumeration getOutputStreams() {
        return outputStreams.elements();
    }

    /**
     * 用于向所有客户端发送消息
     */
    void sendToAll(String message) {
        // 遍历哈希表并将消息发送到每个输出流
        for (Enumeration e = getOutputStreams(); e.hasMoreElements(); ) {
            DataOutputStream dout = (DataOutputStream) e.nextElement();
            try {
                // 写信息
                dout.writeUTF(message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class CliectThread extends Thread {
        private Server server;
        private Socket socket;

        /**
         * 构造一个线程
         */
        public CliectThread(Server server, Socket socket) {
            this.socket = socket;
            this.server = server;
            start();
        }

        /**
         * 运行线程
         */
        @Override
        public void run() {
            try {
                // 创建数据输入和输出流
                DataInputStream din = new DataInputStream(socket.getInputStream());

                // 持续为客户服务
                while (true) {
                    String string = din.readUTF();

                    // 发回文字给客户
                    server.sendToAll(string);

                    // 将聊天添加到服务器jta
                    ta.appendText(string + '\n');
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 仅有限JavaFX支持的IDE才需要main方法。从命令行运行不需要。
     */
    public static void main(String[] args) {
        launch(args);
    }
}
