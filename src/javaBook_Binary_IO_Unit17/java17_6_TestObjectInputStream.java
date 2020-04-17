package javaBook_Binary_IO_Unit17;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 1.创建对象输入流  2.按照写入的顺序来读取
 */
public class java17_6_TestObjectInputStream {
    public static void main(String[] args)
            throws ClassNotFoundException, IOException {
        try ( // Create an input stream for file object.dat
              // 创建(对象)文件输入流
              ObjectInputStream input = new ObjectInputStream(new FileInputStream("java17_5_TestObjectOutputStream_object.dat"));
        ) {
            // Read a string, double value, and object from the file
            // 使用 read 读取数据
            String name = input.readUTF();
            double score = input.readDouble();
            // data是一个对象，不是基本类型
            java.util.Date date = (java.util.Date) (input.readObject());
            // 显示到控制台上
            System.out.println(name + " " + score + " " + date);
        }
    }
}
// 可读取写入的文件类型： 字节，基本类型，String，对象
// 读写对象时，可能出现问题。出现读的不对的问题。浅拷贝(拷贝引用，不拷贝实际值)  深拷贝