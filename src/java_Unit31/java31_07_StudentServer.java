package java_Unit31;

import java.io.*;
import java.net.*;

public class java31_07_StudentServer {
    /** �����ϴ��Ͷ��� */
    private ObjectOutputStream outputToFile;
    private ObjectInputStream inputFromClient;

    public static void main(String[] args) {
        // ����ѧ�������������
        new java31_07_StudentServer();
    }

    public java31_07_StudentServer() {
        try {
            // Create a server socket
            // ����ѧ����������˿�
            ServerSocket serverSocket = new ServerSocket(8001);
            // �����������������Ϣ
            System.out.println("java31_01_Server started ");

            // Create an object ouput stream
            // ��ѧ�������ŵ��ļ���
            outputToFile = new ObjectOutputStream(
                    new FileOutputStream("student.dat", true));

            while (true) {
                // Listen for a new connection request
                // ����һ���ͻ��˵�����
                Socket socket = serverSocket.accept();

                // Create an input stream from the socket
                // �ͻ����������������Ϣ
                inputFromClient =
                        new ObjectInputStream(socket.getInputStream());

                // Read from input
                Object object = inputFromClient.readObject();

                // Write to the file
                // ������д���ļ���
                outputToFile.writeObject(object);
                // �����Ϣ��һ����ѧ���Ѿ��洢
                System.out.println("A new student object is stored");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                // �ر��������������
                inputFromClient.close();
                outputToFile.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
