package java_Unit31;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class java31_02_Client_2 {
    /**
     * IO 流
     */
    public static DataOutputStream toServer = null;
    public static DataInputStream fromServer = null;

    public static void Client() throws IOException {
        double radius = 0.1;
        Scanner input = new Scanner(System.in);


        // 面板 p 容纳标签和文本字段
//        BorderPane paneForTextField = new BorderPane();
//        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
//        paneForTextField.setStyle("-fx-border-color: green");
//        paneForTextField.setLeft(new Label("输入半径: "));

//        TextField tf = new TextField();
//        tf.setAlignment(Pos.BOTTOM_RIGHT);
//        paneForTextField.setCenter(tf);
//
//        BorderPane mainPane = new BorderPane();
//        // 显示内容的文字区域
//        TextArea ta = new TextArea();
//        mainPane.setCenter(new ScrollPane(ta));
//        mainPane.setTop(paneForTextField);
//
//        // 创建一个场景并将其放置在舞台上
//        Scene scene = new Scene(mainPane, 450, 200);
//        // 设置舞台标题
//        primaryStage.setTitle("java31_02_Client");
//        // 将场景放置在舞台上
//        primaryStage.setScene(scene);
//        // 展示舞台
//        primaryStage.show();


        //        try {
        // 创建一个套接字以连接到服务器，127.0.0.1  指向本地机
        Socket socket = new Socket("localhost", 8000);
        // Socket socket = new Socket("130.254.204.36", 8000);
        // Socket socket = new Socket("drake.Armstrong.edu", 8000);

        // 创建输入流以从服务器接收数据
        fromServer = new DataInputStream(socket.getInputStream());

        // 创建输出流以将数据发送到服务器
        toServer = new DataOutputStream(socket.getOutputStream());
//        } catch (IOException ex) {
//            System.out.println(ex.toString() + '\n');
//        }


        while (true) {
            System.out.print("输入半径: ");
            radius = input.nextDouble();

//        tf.setOnAction(e -> {
//            try {
            // 从文本字段获取半径
//                double radius = Double.parseDouble(tf.getText().trim());

            // 将半径发送到服务器
            toServer.writeDouble(radius);
            // 清除流中的数据
            toServer.flush();

            // 从服务器获取区域
            double area = fromServer.readDouble();

            // 显示到文本区域
            System.out.println("半径为 " + radius + "\n");
            System.out.println("从服务器收到的面积是 " + area + '\n');
//            } catch (IOException ex) {
//                System.err.println(ex);
//            }
//        });



        }
    }

    /**
     * 仅具有有限JavaFX支持的IDE才需要main方法。从命令行运行不需要。
     */
    public static void main(String[] args) throws IOException {
//        Client();

        Socket socket = new Socket("127.0.0.1", 8000);
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());

        while (true) {
            System.out.println("输入半径：");
            Scanner input = new Scanner(System.in);
            double radius = input.nextDouble();


            toServer.writeDouble(radius);
            System.out.println(fromServer.readDouble());
        }

        // 示例代码
//        Socket socket = new Socket("127.0.0.1", 8000);
//        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
//        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
//        toServer.writeDouble(13.0);
//        System.out.println(fromServer.readDouble());
    }
}
// 进程被占用时 cmd 命令
// 检查正在占用 8000 端口在进程： netstat -ano|findstr 8000
// 结束对应编号在进程： taskkill -f -pid 21576