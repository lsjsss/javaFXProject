package javaclass_Binary_IO_Unit17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
    FileInputStream fis;
    {
        try {
            fis = new FileInputStream("out.dat");
            try {
                //读取文件,使用i接收数据
                int i = fis.read();
                System.out.println(i);
                //继续接收文件
                int j = fis.read();
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
