package javafileclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
    FileInputStream fis;
    {
        try {
            fis = new FileInputStream("out.dat");
            try {
                int i = fis.read();//读取文件,使用i接收数据
                System.out.println(i);
                int j = fis.read();//继续接收文件
                System.out.println(j);
                int k = fis.read();
                System.out.println(k);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
