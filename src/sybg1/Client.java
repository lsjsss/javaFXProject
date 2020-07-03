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
 * ����TCPЭ��������ҳ��� �ͻ���
 * @author lsjss
 */
public class Client extends Application {
    /**
     * �����ı��ֶ�
     */
    private TextField tf = new TextField();

    /**
     * ���Ƶ��ı��ֶ�
     */
    private TextField tfName = new TextField("01");

    /**
     * ��ʾ���ݵ���������
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
     * ����Application���е�start����
     */
    @Override
    public void start(Stage primaryStage) {
        ClientUI(primaryStage);
    }

    public void ClientUI(Stage primaryStage) {
        ta.setWrapText(true);

        GridPane gridPane = new GridPane();
        gridPane.add(new Label("��Ϣ����"), 0, 0);
        gridPane.add(new Label("�û���"), 0, 1);
        gridPane.add(tf, 1, 0);
        gridPane.add(tfName, 1, 1);


        HBox hBox = new HBox();
        TextArea text = new TextArea();

        text.setMaxSize(300, 5);

        Button send = new Button("������Ϣ");
        Button start = new Button("��������");

        hBox.getChildren().addAll(gridPane, send, start);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(new ScrollPane(ta), hBox);

        // ע�������
        tf.setOnAction(e -> process());
        send.setOnAction(e -> process());
        start.setOnAction(e -> {
            try {
                // ����һ���׽��������ӵ�������
                socket = new Socket("localhost", 8000);

                // �����������Դӷ�������������
                din = new DataInputStream(socket.getInputStream());

                // ����������Խ����ݷ��͵�������
                dout = new DataOutputStream(socket.getOutputStream());

                // ����һ���µ��߳���������Ϣ
                new Thread(() -> run()).start();

                dout.writeUTF("���ӷ������ɹ����˿ڣ�" + socket.getLocalPort());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // ����һ�������������������̨��
        Scene scene = new Scene(vBox, 520, 220);
        // ������̨����
        primaryStage.setTitle("TCPClient");
        // ��������������̨��
        primaryStage.setScene(scene);
        // չʾ��̨
        primaryStage.show();
    }

    public void run() {
        try {
            while (true) {
                // ȡ��ѶϢ
                String text = din.readUTF();

                // ��ʾ���ı�����
                ta.appendText(text + '\n');
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void process() {
        try {
            // ���ı��ֶλ�ȡ�ı�
            String string = tfName.getText().trim() + ">> " + tf.getText().trim();

            // ���ı����͵�������
            dout.writeUTF(string);

            // Clear jtf
            tf.setText("");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * ������JavaFX֧�ֵ�IDE����Ҫmain�����������������в���Ҫ��
     */
    public static void main(String[] args) {
        launch(args);
    }
}
