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
 * ����TCPЭ��������ҳ��� ��������
 * @author lsjss
 */
public class Server extends Application {
    /**
     * ������ʾ���ݵ��ı�����
     */
    private TextArea ta = new TextArea();

    /**
     * �׽��ֵ��������ӳ��
     */
    private Hashtable outputStreams = new Hashtable();

    /**
     * ����������
     */
    private ServerSocket serverSocket;

    TextField text = new TextField();

    /**
     * ����Application���е�start����
     */
    @Override
    public void start(Stage primaryStage) {
        ServerUI(primaryStage);
    }

    private void ServerUI(Stage primaryStage) {
        ta.setWrapText(true);

        HBox hBox = new HBox();

        Button send = new Button("������Ϣ");
        Button start = new Button("��������");

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

        // ����һ�������������������̨��
        Scene scene = new Scene(vBox, 520, 220);
        // ������̨����
        primaryStage.setTitle("TCPServer");
        // ��������������̨��
        primaryStage.setScene(scene);
        // չʾ��̨
        primaryStage.show();
    }

    private void ListenerClient() {
        try {
            // �����������׽���
            serverSocket = new ServerSocket(8000);
            Platform.runLater(() ->
                    ta.appendText("��������ɹ����˿�" + serverSocket.getLocalPort() + '\n' + "�ȴ��ͻ���" + '\n'));

            while (true) {
                // �����µ���������
                Socket socket = serverSocket.accept();

                // ��ʾ�ͻ����
                Platform.runLater(() ->
                        ta.appendText("���ӳɹ� " + socket + '\n' + "�ȴ��ͻ���" + '\n'));

                // ���������
                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

                // ����������浽��ϣ��
                outputStreams.put(socket, dout);

                // Ϊ���Ӵ���һ�����߳�
                new CliectThread(this, socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ���ڻ�ȡ�����
     */
    Enumeration getOutputStreams() {
        return outputStreams.elements();
    }

    /**
     * ���������пͻ��˷�����Ϣ
     */
    void sendToAll(String message) {
        // ������ϣ������Ϣ���͵�ÿ�������
        for (Enumeration e = getOutputStreams(); e.hasMoreElements(); ) {
            DataOutputStream dout = (DataOutputStream) e.nextElement();
            try {
                // д��Ϣ
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
         * ����һ���߳�
         */
        public CliectThread(Server server, Socket socket) {
            this.socket = socket;
            this.server = server;
            start();
        }

        /**
         * �����߳�
         */
        @Override
        public void run() {
            try {
                // ������������������
                DataInputStream din = new DataInputStream(socket.getInputStream());

                // ����Ϊ�ͻ�����
                while (true) {
                    String string = din.readUTF();

                    // �������ָ��ͻ�
                    server.sendToAll(string);

                    // ��������ӵ�������jta
                    ta.appendText(string + '\n');
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * ������JavaFX֧�ֵ�IDE����Ҫmain�����������������в���Ҫ��
     */
    public static void main(String[] args) {
        launch(args);
    }
}
