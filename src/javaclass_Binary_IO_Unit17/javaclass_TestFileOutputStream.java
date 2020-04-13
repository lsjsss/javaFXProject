package javaclass_Binary_IO_Unit17;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//从 java 输出信息到文件，使用二进制形式输出
public class javaclass_TestFileOutputStream {
    public static void main(String[] args) {
        /** 1.创建一个输出流；和文件关联
         * 2.向输出流写入信息
         * 3.关闭流
         */
        try {
            //步骤1:关联流和文件
            FileOutputStream fos = new FileOutputStream("javaclass_TestFileOutputStream_out.dat");
            for (int i = 0; i < 10; i++) {//写入十个字节
                fos.write(i);
            }

            //输出 222 (写入到out.dat， 二进制信息 1101 1110)
            fos.write(222);
            fos.close();//关闭流
        //文件未找到异常
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        //文件写入异常
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//文件一定在，不存在的情况下，会自动创建一个