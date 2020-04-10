package javafileclass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//从 java 输出信息到文件，使用二进制形式输出
public class TestFileOutputStream {
    public static void main(String[] args) {
        /** 1.创建一个输出流；和文件关联
         * 2.向输出流写入信息
         * 3.关闭流
         */
        try {
            FileOutputStream fos = new FileOutputStream("out.dat");//步骤1:关联流和文件
            fos.write(222);//输出 222 (二进制信息)
            fos.close();//关闭流
        } catch (FileNotFoundException e) {//文件未找到异常
            e.printStackTrace();
        } catch (IOException e) {//文件写入异常
            e.printStackTrace();
        }
    }
}
//文件一定在，不存在的情况下，会自动创建一个