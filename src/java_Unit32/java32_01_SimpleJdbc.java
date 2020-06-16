package java_Unit32;

import java.sql.*;

/** ��Ҫ��� mysql-connector-java-5.1.26-bin.jar */
public class java32_01_SimpleJdbc {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        // ���� JDBC ��������
        Class.forName("com.mysql.jdbc.Driver");
//        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("���������Ѽ���");

        // ��������
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/javabook", "scott", "tiger");
        System.out.println("���ݿ�������");

        // ��������
        Statement statement = connection.createStatement();

        // ִ�����,ͨ�� statement ���ִ��
        ResultSet resultSet = statement.executeQuery
                ("select firstName, mi, lastName from Student where lastName "
                        + " = 'Smith'");

        // �����������ӡѧ������
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "\t" +
                    resultSet.getString(2) + "\t" + resultSet.getString(3));
        }

        // �ر�����
        connection.close();
    }
}
