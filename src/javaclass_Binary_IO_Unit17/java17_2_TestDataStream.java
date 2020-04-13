package javaclass_Binary_IO_Unit17;

import java.io.*;
/** 使用 DataInputStream   DataOutputStream
 * 可以直接读(read)...、写(Write)...  8种基本数据类型，字符串
 * 参数 .... 字节流(InputStream 子类)做参数
 * 读的顺序一定要与元数据顺序匹配， 否则不正确 */
public interface java17_2_TestDataStream {
    public static void main(String[] args) throws IOException {
        try (
                DataOutputStream output = new DataOutputStream(new FileOutputStream("java17_1_TestFileStream_temp.dat"));
                ) {
            //写入数据
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("George");
            output.writeDouble(105.25);
        }

        try (
                DataInputStream input = new DataInputStream(new FileInputStream("java17_1_TestFileStream_temp.dat"));
                ) {
            //读取数据并输出到控制台
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}
