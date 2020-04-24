package javaBook_Binary_IO_Unit17;

import java.io.IOException;
import java.io.RandomAccessFile;

public class java17_08_TestRandomAccessFile {
    public static void main(String[] args) throws IOException {
        try ( // Create a random access file
              //创建随机存取文件对象(读/写)
              RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw");
        ) {
            // Clear the file to destroy the old contents if exists
            //将文件长度设置为 0 (清除文件内容)
            inout.setLength(0);

            // Write new integers to the file
            //写入 0 - 199 ，200个整数  800(200*4)字节
            for (int i = 0; i < 200; i++) {
                inout.writeInt(i);
            }

            // Display the current length of the file
            //当前文件长度(800)
            System.out.println("Current file length is " + inout.length());

            // Retrieve the first number
            // Move the file pointer to the beginning
            // 把指针定位到第 0 个字节(文件开头) 读取一个整数
            inout.seek(0);
            System.out.println("The first number is " + inout.readInt());

            // Retrieve the second number
            // Move the file pointer to the second number
            // 定位到数字 1 的位置
            inout.seek(1 * 4);
            System.out.println("The second number is " + inout.readInt());

            // Retrieve the tenth number
            // Move the file pointer to the tenth number
            // 定位到数字 9 的位置
            inout.seek(9 * 4);
            System.out.println("The tenth number is " + inout.readInt());

            // Modify the eleventh number
            //写入 555 (并不是写到文件尾)，写到指针所在的位置(第 10 个元素的位置)
            inout.writeInt(555);

            // Append a new number
            // Move the file pointer to the end
            // 把指针定位到文件的最后位置，写入 999
            inout.seek(inout.length());
            inout.writeInt(999);

            // Display the new length
            System.out.println("The new length is " + inout.length());

            // Retrieve the new eleventh number
            // Move the file pointer to the eleventh number
            inout.seek(10 * 4);
            System.out.println("The eleventh number is " + inout.readInt());

            //读取指针下一个数组
            System.out.println("The eleventh number is " + inout.readInt());
        }
    }
}
