package sybg1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 基于TCP协议的聊天室程序 客户端
 * @author lsjss
 */
public class Client extends Application {
    /**
     * 聊天文本字段
     */
    private TextField tf = new TextField();

    /**
     * 名称的文本字段
     */
    private TextField tfName = new TextField("01");

    /**
     * 显示内容的文字区域
     */
    private TextArea ta = new TextArea();

    /**
     * Socket
     */
    private Socket socket;

    /**
     * IO streams
     */
    private DataOutputStream dout;
    private DataInputStream din;

    /**
     * 覆盖Application类中的start方法
     */
    @Override
    public void start(Stage primaryStage) {
        ClientUI(primaryStage);
    }

    public void ClientUI(Stage primaryStage) {
        ta.setWrapText(true);

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("信息内容"), 0, 0);
        gridPane.add(new Label("用户名"), 0, 1);
        gridPane.add(tf, 1, 0);
        gridPane.add(tfName, 1, 1);


        HBox hBox = new HBox();
        TextArea text = new TextArea();

        text.setMaxSize(300, 5);

        Button send = new Button("发送信息");
        Button start = new Button("启动服务");

        hBox.getChildren().addAll(gridPane, send, start);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(new ScrollPane(ta), hBox);

        // 注册监听器
        tf.setOnAction(e -> process());
        send.setOnAction(e -> process());
        start.setOnAction(e -> {
            try {
                // 创建一个套接字以连接到服务器
                socket = new Socket("localhost", 8000);

                // 创建输入流以从服务器接收数据
                din = new DataInputStream(socket.getInputStream());

                // 创建输出流以将数据发送到服务器
                dout = new DataOutputStream(socket.getOutputStream());

                // 启动一个新的线程来接收消息
                new Thread(() -> run()).start();

                dout.writeUTF("连接服务器成功，端口：" + socket.getLocalPort());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // 创建一个场景并将其放置在舞台上
        Scene scene = new Scene(vBox, 520, 220);
        // 设置舞台标题
        primaryStage.setTitle("TCPClient");
        // 将场景放置在舞台上
        primaryStage.setScene(scene);
        // 展示舞台
        primaryStage.show();
    }

    public void run() {
        try {
            while (true) {
                // 取得讯息
                String text = din.readUTF();

                // 显示到文本区域
                ta.appendText(text + '\n');
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void process() {
        try {
            // 从文本字段获取文本
            String string = tfName.getText().trim() + ">> " + tf.getText().trim();

            // 将文本发送到服务器
            dout.writeUTF(string);

            // Clear jtf
            tf.setText("");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * 仅有限JavaFX支持的IDE才需要main方法。从命令行运行不需要。
     */
    public static void main(String[] args) {
        launch(args);
    }
}
