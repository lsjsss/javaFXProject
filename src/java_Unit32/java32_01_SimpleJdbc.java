package java_Unit32;

import java.sql.*;

/** 需要添加 mysql-connector-java-5.1.26-bin.jar */
public class java32_01_SimpleJdbc {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        // 加载 JDBC 驱动程序
        Class.forName("com.mysql.jdbc.Driver");
//        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("驱动程序已加载");

        // 建立连接
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("数据库已连接");

        // 建立陈述
        Statement statement = connection.createStatement();

        // 执行语句,通过 statement 语句执行
        ResultSet resultSet = statement.executeQuery
                ("select firstName, mi, lastName from Student where lastName "
                        + " = 'Smith'");

        // 遍历结果并打印学生姓名
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "\t" +
                    resultSet.getString(2) + "\t" + resultSet.getString(3));
        }

        // 关闭连接
        connection.close();
    }
}
