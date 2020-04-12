package javaclass_Binary_IO_Unit17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class javaclass_TestFileInputStream {
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("javaclass_TestFileOutputStream_out.dat");
                //读取文件,使用i接收数据
                int i = fis.read();
                System.out.println(i);
                //继续接收文件
                int j = fis.read();
                System.out.println(j);
                int k = fis.read();
                System.out.println(k);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
