package java_Unit31;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class java31_01_Server_2 {
    public static void Server() throws IOException {
//        while(true) {
        new Thread(() -> {
        try {
            // �����������׽���
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("java31_01_Server ��ʼ�� " + new Date() + '\n');
//            Platform.runLater(() ->
//                    ta.appendText("java31_01_Server started at " + new Date() + '\n'));

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

//                Platform.runLater(() -> {
                            System.out.println("�ӿͻ����յ��İ뾶: "
                                    + radius);
                            System.out.println("Area is: " + area);
//                        });
//                Platform.runLater(() -> {
//                    ta.appendText("Radius received from client: "
//                            + radius + '\n');
//                    ta.appendText("Area is: " + area + '\n');
//                });
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        });
    }

    /**
     * ����������JavaFX֧�ֵ�IDE����Ҫmain�����������������в���Ҫ��
     */
    public static void main(String[] args) throws IOException {
//        Server();

        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

        while (true) {
            double radius = inputFromClient.readDouble();
            double area = radius * radius * Math.PI;
            outputToClient.writeDouble(area);
            System.out.println(area);
        }

        // ʾ������
//        ServerSocket serverSocket = new ServerSocket(8000);
//        Socket socket = serverSocket.accept();
//        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
//        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
//        double radius = inputFromClient.readDouble();
//        double area = radius * radius * Math.PI;
//        outputToClient.writeDouble(area);
    }
}
// ���̱�ռ��ʱ cmd ����
// �������ռ�� 8000 �˿��ڽ��̣� jiannetstat -ano|findstr 8000
// ������Ӧ����ڽ��̣� taskkill -f -pid 21576
