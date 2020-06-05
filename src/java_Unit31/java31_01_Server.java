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
    /** ����Application���е�start���� */
    @Override
    public void start(Stage primaryStage) {
        // ������ʾ���ݵ��ı�����
        TextArea ta = new TextArea();

        // ����һ�������������������̨��
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        // ������̨����
        primaryStage.setTitle("java31_01_Server");
        // ��������������̨��
        primaryStage.setScene(scene);
        // չʾ��̨
        primaryStage.show();

        new Thread(() -> {
            try {
                // �����������׽���
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() ->
                        ta.appendText("java31_01_Server started at " + new Date() + '\n'));

                // ������������
                Socket socket = serverSocket.accept();

                // ������������������
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());

                while (true) {
                    // �ӿͻ��˽��հ뾶
                    double radius = inputFromClient.readDouble();

                    // �������
                    double area = radius * radius * Math.PI;

                    // �������ͻؿͻ�
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
     * ����������JavaFX֧�ֵ�IDE����Ҫmain�����������������в���Ҫ��
     */
    public static void main(String[] args) {
        launch(args);
    }
}
