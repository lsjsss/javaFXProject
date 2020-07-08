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
        // 添加按钮
        Button b1 = new Button("查看/刷新留言");
        Button b2 = new Button("我要留言");
        Button b3 = new Button("清除历史留言");
        Button b4 = new Button("提交留言");
        // 设置按钮大小
        b1.setMinSize(150, 25);
        b2.setMinSize(150, 25);
        b3.setMinSize(150, 25);
        b4.setMinSize(150, 25);
        // 添加文本域
        TextArea ta = new TextArea();
        // 设置文本域自动换行
        ta.setWrapText(true);
        // 设置文本域大小
        ta.setMinSize(450, 575);

        // 创建水平盒子，放置按钮
        HBox hBox = new HBox();
        hBox.getChildren().addAll(b1, b2, b3);

        // 创建垂直盒子，放置所有组件
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, ta);

        // 加载 JDBC 驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("驱动程序已加载");

        // 建立连接
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/test", "root", "");
        System.out.println("数据库已连接");

        // 建立陈述
        Statement statement = connection.createStatement();

        // 执行语句,通过 statement 语句执行
        AtomicReference<ResultSet> resultSet = new AtomicReference<>(statement.executeQuery
                ("select * from messagebook"));

        // 我要留言按钮动作事件
        b2.setOnAction(e -> {
            hBox.getChildren().addAll(1, Collections.singleton(b4));
            hBox.getChildren().remove(2);
            ta.clear();
            ta.appendText("留言信息：");
        });

        // 提交留言按钮动作事件
        b4.setOnAction(e -> {
            hBox.getChildren().addAll(1, Collections.singleton(b2));
            hBox.getChildren().remove(2);

            // 执行语句,通过 statement 语句执行，向表中插入数据(提交留言)
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
            ta.appendText("留言已提交...");
        });

        // 查看/刷新留言按钮事件
        b1.setOnAction(e -> {
            hBox.getChildren().remove(1);
            hBox.getChildren().addAll(1, Collections.singleton(b2));
            ta.clear();
            ta.appendText("留言记录：\n");

            // 执行语句,通过 statement 语句执行
            try {
                resultSet.set(statement.executeQuery
                        ("select * from messagebook"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            // 遍历结果并打印学生姓名
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

        // 清除历史留言按钮事件
        b3.setOnAction(e -> {
            hBox.getChildren().remove(1);
            hBox.getChildren().addAll(1, Collections.singleton(b2));
            ta.clear();
            ta.appendText("历史留言已清除...");

            try {
                statement.execute
                        ("truncate table messagebook");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        // 监听窗口是否关闭
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.print("窗口关闭");
                // 关闭数据库连接
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


        // 创建一个场景并将其放置在舞台上
        Scene scene = new Scene(vBox, 450, 600);
        // 设置舞台标题
        primaryStage.setTitle("MessageBook V2.0");
        // 将场景放置在舞台上
        primaryStage.setScene(scene);
        // 展示舞台
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
