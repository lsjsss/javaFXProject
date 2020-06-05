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
     * IO ��
     */
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;

    /**
     * ���� Application ���е� start ����
     */
    @Override
    public void start(Stage primaryStage) {
        // ��� p ���ɱ�ǩ���ı��ֶ�
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("����뾶: "));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);

        BorderPane mainPane = new BorderPane();
        // ��ʾ���ݵ���������
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);

        // ����һ�������������������̨��
        Scene scene = new Scene(mainPane, 450, 200);
        // ������̨����
        primaryStage.setTitle("java31_02_Client");
        // ��������������̨��
        primaryStage.setScene(scene);
        // չʾ��̨
        primaryStage.show();

        tf.setOnAction(e -> {
            try {
                // ���ı��ֶλ�ȡ�뾶
                double radius = Double.parseDouble(tf.getText().trim());

                // ���뾶���͵�������
                toServer.writeDouble(radius);
                // ������е�����
                toServer.flush();

                // �ӷ�������ȡ����
                double area = fromServer.readDouble();

                // ��ʾ���ı�����
                ta.appendText("�뾶Ϊ " + radius + "\n");
                ta.appendText("�ӷ������յ�������� " + area + '\n');
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });

        try {
            // ����һ���׽��������ӵ���������127.0.0.1  ָ�򱾵ػ�
            Socket socket = new Socket("localhost", 8000);
            // Socket socket = new Socket("130.254.204.36", 8000);
            // Socket socket = new Socket("drake.Armstrong.edu", 8000);

            // �����������Դӷ�������������
            fromServer = new DataInputStream(socket.getInputStream());

            // ����������Խ����ݷ��͵�������
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ta.appendText(ex.toString() + '\n');
        }
    }

    /**
     * ����������JavaFX֧�ֵ�IDE����Ҫmain�����������������в���Ҫ��
     */
    public static void main(String[] args) {
        launch(args);
    }
}
