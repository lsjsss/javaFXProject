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
     * ������ʾ���ݵ��ı�����
     * Text area for displaying contents
     */
    private TextArea ta = new TextArea();

    /**
     * Ϊ�ͻ���� (�ͻ��˱��)
     * Number a client
     */
    private int clientNo = 0;

    /**
     * ����Application���е�start����
     * Override the start method in the Application class
     */
    @Override
    public void start(Stage primaryStage) {
        // ����һ�������������������̨��  Create a scene and place it in the stage
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        // ������̨����  Set the stage title
        primaryStage.setTitle("java31_04_MultiThreadServer");
        // ��������������̨��  Place the scene in the stage
        primaryStage.setScene(scene);
        // չʾ��̨  Display the stage
        primaryStage.show();

        // lamdba ���ʽ
        new Thread(() -> {
            try {
                // �����������׽���  Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                // ��ʾ����ʱ��
                ta.appendText("java31_04_MultiThreadServer started at "
                        + new Date() + '\n');

                while (true) {
                    // �����µ���������  Listen for a new connection request
                    Socket socket = serverSocket.accept();

                    // �ͻ�������  Increment clientNo
                    clientNo++;

                    Platform.runLater(() -> {
                        // ��ʾ�ͻ����  Display the client number
                        ta.appendText("�ͻ��������߳� " + clientNo +
                                " at " + new Date() + '\n');

                        // ���ҿͻ��˵���������IP��ַ  Find the client's host name, and IP address
                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("java31_02_Client " + clientNo + "'s ���������� "
                                + inetAddress.getHostName() + "\n");
                        ta.appendText("java31_02_Client " + clientNo + "'s �� IP ��ַ�� "
                                + inetAddress.getHostAddress() + "\n");
                    });

                    // �����������µ������߳�  Create and start a new thread for the connection
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
                // ������������������  Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());

                // ����Ϊ�ͻ�����  Continuously serve the client
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
