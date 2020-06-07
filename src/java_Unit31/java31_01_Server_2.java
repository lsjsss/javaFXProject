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
            // 创建服务器套接字
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("java31_01_Server 开始于 " + new Date() + '\n');
//            Platform.runLater(() ->
//                    ta.appendText("java31_01_Server started at " + new Date() + '\n'));

            // 监听连接请求
            Socket socket = serverSocket.accept();

            // 创建数据输入和输出流
            DataInputStream inputFromClient = new DataInputStream(
                    socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(
                    socket.getOutputStream());

            while (true) {
                // 从客户端接收半径
                double radius = inputFromClient.readDouble();

                // 计算面积
                double area = radius * radius * Math.PI;

                // 将区域发送回客户
                outputToClient.writeDouble(area);

//                Platform.runLater(() -> {
                            System.out.println("从客户端收到的半径: "
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
     * 仅具有有限JavaFX支持的IDE才需要main方法。从命令行运行不需要。
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

        // 示例代码
//        ServerSocket serverSocket = new ServerSocket(8000);
//        Socket socket = serverSocket.accept();
//        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
//        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
//        double radius = inputFromClient.readDouble();
//        double area = radius * radius * Math.PI;
//        outputToClient.writeDouble(area);
    }
}
// 进程被占用时 cmd 命令
// 检查正在占用 8000 端口在进程： jiannetstat -ano|findstr 8000
// 结束对应编号在进程： taskkill -f -pid 21576
