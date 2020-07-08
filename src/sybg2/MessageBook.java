package sybg2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.sql.*;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public class MessageBook extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // ��Ӱ�ť
        Button b1 = new Button("�鿴/ˢ������");
        Button b2 = new Button("��Ҫ����");
        Button b3 = new Button("�����ʷ����");
        Button b4 = new Button("�ύ����");
        // ���ð�ť��С
        b1.setMinSize(150, 25);
        b2.setMinSize(150, 25);
        b3.setMinSize(150, 25);
        b4.setMinSize(150, 25);
        // ����ı���
        TextArea ta = new TextArea();
        // �����ı����Զ�����
        ta.setWrapText(true);
        // �����ı����С
        ta.setMinSize(450, 575);

        // ����ˮƽ���ӣ����ð�ť
        HBox hBox = new HBox();
        hBox.getChildren().addAll(b1, b2, b3);

        // ������ֱ���ӣ������������
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, ta);

        // ���� JDBC ��������
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("���������Ѽ���");

        // ��������
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/test", "root", "");
        System.out.println("���ݿ�������");

        // ��������
        Statement statement = connection.createStatement();

        // ִ�����,ͨ�� statement ���ִ��
        AtomicReference<ResultSet> resultSet = new AtomicReference<>(statement.executeQuery
                ("select * from messagebook"));

        // ��Ҫ���԰�ť�����¼�
        b2.setOnAction(e -> {
            hBox.getChildren().addAll(1, Collections.singleton(b4));
            hBox.getChildren().remove(2);
            ta.clear();
            ta.appendText("������Ϣ��");
        });

        // �ύ���԰�ť�����¼�
        b4.setOnAction(e -> {
            hBox.getChildren().addAll(1, Collections.singleton(b2));
            hBox.getChildren().remove(2);

            // ִ�����,ͨ�� statement ���ִ�У�����в�������(�ύ����)
            try {
                String s = ta.getText();
                statement.execute
                        ("insert into messagebook(date, time, message) " +
                                "values (curdate(), CURRENT_TIME(), '" +
                                s + "');");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            ta.clear();
            ta.appendText("�������ύ...");
        });

        // �鿴/ˢ�����԰�ť�¼�
        b1.setOnAction(e -> {
            hBox.getChildren().remove(1);
            hBox.getChildren().addAll(1, Collections.singleton(b2));
            ta.clear();
            ta.appendText("���Լ�¼��\n");

            // ִ�����,ͨ�� statement ���ִ��
            try {
                resultSet.set(statement.executeQuery
                        ("select * from messagebook"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            // �����������ӡѧ������
            while (true) {
                try {
                    if (!resultSet.get().next()) {
                        break;
                    }
                    ta.appendText(resultSet.get().getString(1) + "\t"
                            + resultSet.get().getString(2) + "\n"
                            + resultSet.get().getString(3) + "\n\n"
                            + "-----------------------------------------------\n");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        // �����ʷ���԰�ť�¼�
        b3.setOnAction(e -> {
            hBox.getChildren().remove(1);
            hBox.getChildren().addAll(1, Collections.singleton(b2));
            ta.clear();
            ta.appendText("��ʷ���������...");

            try {
                statement.execute
                        ("truncate table messagebook");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        // ���������Ƿ�ر�
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.print("���ڹر�");
                // �ر����ݿ�����
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


        // ����һ�������������������̨��
        Scene scene = new Scene(vBox, 450, 600);
        // ������̨����
        primaryStage.setTitle("MessageBook V2.0");
        // ��������������̨��
        primaryStage.setScene(scene);
        // չʾ��̨
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
