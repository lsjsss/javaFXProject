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
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class java31_04_MultiThreadServer extends Application {
    /**
     * 用于显示内容的文本区域
     * Text area for displaying contents
     */
    private TextArea ta = new TextArea();

    /**
     * 为客户编号 (客户端编号)
     * Number a client
     */
    private int clientNo = 0;

    /**
     * 覆盖Application类中的start方法
     * Override the start method in the Application class
     */
    @Override
    public void start(Stage primaryStage) {
        // 创建一个场景并将其放置在舞台上  Create a scene and place it in the stage
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        // 设置舞台标题  Set the stage title
        primaryStage.setTitle("java31_04_MultiThreadServer");
        // 将场景放置在舞台上  Place the scene in the stage
        primaryStage.setScene(scene);
        // 展示舞台  Display the stage
        primaryStage.show();

        // lamdba 表达式
        new Thread(() -> {
            try {
                // 创建服务器套接字  Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                // 显示启动时间
                ta.appendText("java31_04_MultiThreadServer started at "
                        + new Date() + '\n');

                while (true) {
                    // 收听新的连接请求  Listen for a new connection request
                    Socket socket = serverSocket.accept();

                    // 客户端增加  Increment clientNo
                    clientNo++;

                    Platform.runLater(() -> {
                        // 显示客户编号  Display the client number
                        ta.appendText("客户端启动线程 " + clientNo +
                                " at " + new Date() + '\n');

                        // 查找客户端的主机名和IP地址  Find the client's host name, and IP address
                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("java31_02_Client " + clientNo + "'s 的主机名是 "
                                + inetAddress.getHostName() + "\n");
                        ta.appendText("java31_02_Client " + clientNo + "'s 的 IP 地址是 "
                                + inetAddress.getHostAddress() + "\n");
                    });

                    // 创建并启动新的连接线程  Create and start a new thread for the connection
                    new Thread(new HandleAClient(socket)).start();
                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }).start();
    }

    /** Define the thread class for handling new connection */
    class HandleAClient implements Runnable {
        // A connected socket
        private Socket socket;

        /**
         * Construct a thread
         */
        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        /**
         * Run a thread
         */
        @Override
        public void run() {
            try {
                // 创建数据输入和输出流  Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());

                // 持续为客户服务  Continuously serve the client
                while (true) {
                    // Receive radius from the client
                    double radius = inputFromClient.readDouble();

                    // Compute area
                    double area = radius * radius * Math.PI;

                    // Send area back to the client
                    outputToClient.writeDouble(area);

                    Platform.runLater(() -> {
                        ta.appendText("radius received from client: " +
                                radius + '\n');
                        ta.appendText("Area found: " + area + '\n');
                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
