package javaBook_Binary_IO_Unit17;

import java.io.IOException;
import java.io.RandomAccessFile;

public class java17_08_TestRandomAccessFile {
    public static void main(String[] args) throws IOException {
        try ( // Create a random access file
              //���������ȡ�ļ�����(��/д)
              RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw");
        ) {
            // Clear the file to destroy the old contents if exists
            //���ļ���������Ϊ 0 (����ļ�����)
            inout.setLength(0);

            // Write new integers to the file
            //д�� 0 - 199 ��200������  800(200*4)�ֽ�
            for (int i = 0; i < 200; i++) {
                inout.writeInt(i);
            }

            // Display the current length of the file
            //��ǰ�ļ�����(800)
            System.out.println("Current file length is " + inout.length());

            // Retrieve the first number
            // Move the file pointer to the beginning
            // ��ָ�붨λ���� 0 ���ֽ�(�ļ���ͷ) ��ȡһ������
            inout.seek(0);
            System.out.println("The first number is " + inout.readInt());

            // Retrieve the second number
            // Move the file pointer to the second number
            // ��λ������ 1 ��λ��
            inout.seek(1 * 4);
            System.out.println("The second number is " + inout.readInt());

            // Retrieve the tenth number
            // Move the file pointer to the tenth number
            // ��λ������ 9 ��λ��
            inout.seek(9 * 4);
            System.out.println("The tenth number is " + inout.readInt());

            // Modify the eleventh number
            //д�� 555 (������д���ļ�β)��д��ָ�����ڵ�λ��(�� 10 ��Ԫ�ص�λ��)
            inout.writeInt(555);

            // Append a new number
            // Move the file pointer to the end
            // ��ָ�붨λ���ļ������λ�ã�д�� 999
            inout.seek(inout.length());
            inout.writeInt(999);

            // Display the new length
            System.out.println("The new length is " + inout.length());

            // Retrieve the new eleventh number
            // Move the file pointer to the eleventh number
            inout.seek(10 * 4);
            System.out.println("The eleventh number is " + inout.readInt());

            //��ȡָ����һ������
            System.out.println("The eleventh number is " + inout.readInt());
        }
    }
}
