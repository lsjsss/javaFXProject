package java_Unit31;

import java.io.*;
import java.net.*;

public class java31_07_StudentServer {
    /** 网络上传送对象 */
    private ObjectOutputStream outputToFile;
    private ObjectInputStream inputFromClient;

    public static void main(String[] args) {
        // 创建学生类服务器对象
        new java31_07_StudentServer();
    }

    public java31_07_StudentServer() {
        try {
            // Create a server socket
            // 创建学生类服务器端口
            ServerSocket serverSocket = new ServerSocket(8001);
            // 输出服务器已启动信息
            System.out.println("java31_01_Server started ");

            // Create an object ouput stream
            // 将学生对象存放到文件中
            outputToFile = new ObjectOutputStream(
                    new FileOutputStream("student.dat", true));

            while (true) {
                // Listen for a new connection request
                // 接受一个客户端的请求
                Socket socket = serverSocket.accept();

                // Create an input stream from the socket
                // 客户端向服务器输入信息
                inputFromClient =
                        new ObjectInputStream(socket.getInputStream());

                // Read from input
                Object object = inputFromClient.readObject();

                // Write to the file
                // 将对象写到文件中
                outputToFile.writeObject(object);
                // 输出信息：一个新学生已经存储
                System.out.println("A new student object is stored");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                // 关闭输入流和输出流
                inputFromClient.close();
                outputToFile.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
