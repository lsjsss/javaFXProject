package javaBook_Binary_IO_Unit17;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 1.��������������  2.����д���˳������ȡ
 */
public class java17_6_TestObjectInputStream {
    public static void main(String[] args)
            throws ClassNotFoundException, IOException {
        try ( // Create an input stream for file object.dat
              // ����(����)�ļ�������
              ObjectInputStream input = new ObjectInputStream(new FileInputStream("java17_5_TestObjectOutputStream_object.dat"));
        ) {
            // Read a string, double value, and object from the file
            // ʹ�� read ��ȡ����
            String name = input.readUTF();
            double score = input.readDouble();
            // data��һ�����󣬲��ǻ�������
            java.util.Date date = (java.util.Date) (input.readObject());
            // ��ʾ������̨��
            System.out.println(name + " " + score + " " + date);
        }
    }
}
// �ɶ�ȡд����ļ����ͣ� �ֽڣ��������ͣ�String������
// ��д����ʱ�����ܳ������⡣���ֶ��Ĳ��Ե����⡣ǳ����(�������ã�������ʵ��ֵ)  ���