package java_Unit31;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class java31_02_Client_2 {
    /**
     * IO ��
     */
    public static DataOutputStream toServer = null;
    public static DataInputStream fromServer = null;

    public static void Client() throws IOException {
        double radius = 0.1;
        Scanner input = new Scanner(System.in);


        // ��� p ���ɱ�ǩ���ı��ֶ�
//        BorderPane paneForTextField = new BorderPane();
//        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
//        paneForTextField.setStyle("-fx-border-color: green");
//        paneForTextField.setLeft(new Label("����뾶: "));

//        TextField tf = new TextField();
//        tf.setAlignment(Pos.BOTTOM_RIGHT);
//        paneForTextField.setCenter(tf);
//
//        BorderPane mainPane = new BorderPane();
//        // ��ʾ���ݵ���������
//        TextArea ta = new TextArea();
//        mainPane.setCenter(new ScrollPane(ta));
//        mainPane.setTop(paneForTextField);
//
//        // ����һ�������������������̨��
//        Scene scene = new Scene(mainPane, 450, 200);
//        // ������̨����
//        primaryStage.setTitle("java31_02_Client");
//        // ��������������̨��
//        primaryStage.setScene(scene);
//        // չʾ��̨
//        primaryStage.show();


        //        try {
        // ����һ���׽��������ӵ���������127.0.0.1  ָ�򱾵ػ�
        Socket socket = new Socket("localhost", 8000);
        // Socket socket = new Socket("130.254.204.36", 8000);
        // Socket socket = new Socket("drake.Armstrong.edu", 8000);

        // �����������Դӷ�������������
        fromServer = new DataInputStream(socket.getInputStream());

        // ����������Խ����ݷ��͵�������
        toServer = new DataOutputStream(socket.getOutputStream());
//        } catch (IOException ex) {
//            System.out.println(ex.toString() + '\n');
//        }


        while (true) {
            System.out.print("����뾶: ");
            radius = input.nextDouble();

//        tf.setOnAction(e -> {
//            try {
            // ���ı��ֶλ�ȡ�뾶
//                double radius = Double.parseDouble(tf.getText().trim());

            // ���뾶���͵�������
            toServer.writeDouble(radius);
            // ������е�����
            toServer.flush();

            // �ӷ�������ȡ����
            double area = fromServer.readDouble();

            // ��ʾ���ı�����
            System.out.println("�뾶Ϊ " + radius + "\n");
            System.out.println("�ӷ������յ�������� " + area + '\n');
//            } catch (IOException ex) {
//                System.err.println(ex);
//            }
//        });



        }
    }

    /**
     * ����������JavaFX֧�ֵ�IDE����Ҫmain�����������������в���Ҫ��
     */
    public static void main(String[] args) throws IOException {
//        Client();

        Socket socket = new Socket("127.0.0.1", 8000);
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());

        while (true) {
            System.out.println("����뾶��");
            Scanner input = new Scanner(System.in);
            double radius = input.nextDouble();


            toServer.writeDouble(radius);
            System.out.println(fromServer.readDouble());
        }

        // ʾ������
//        Socket socket = new Socket("127.0.0.1", 8000);
//        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
//        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
//        toServer.writeDouble(13.0);
//        System.out.println(fromServer.readDouble());
    }
}
// ���̱�ռ��ʱ cmd ����
// �������ռ�� 8000 �˿��ڽ��̣� netstat -ano|findstr 8000
// ������Ӧ����ڽ��̣� taskkill -f -pid 21576