package javaclass_Binary_IO_Unit17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class javaclass_TestFileInputStream {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("javaclass_TestFileOutputStream_out.dat");

            //0....9
            System.out.println(fis.read());
            //跳过n个字节
            fis.skip(2);
            //测试是否支持 mark。 测试结果输入流不支持 mark
            System.out.println(fis.read());
            System.out.println(fis.markSupported());
//            fis.mark(2);
//            System.out.println(fis.read());
//            fis.reset();
//            System.out.println(fis.read());


            //能读多少个字节
            System.out.println("可读取字节数" + fis.available());


            //off len
            byte[] b = new byte[12];
            //读取第 0 - 8 个数据    b[1]=0  b[2]=1  b[9]=8
            fis.read(b, 1, 9);
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + " ");
            }
            //运行结果 0 0 1 2 3 4 5 6 7 8 0 0


//            //一次读出十个字节
//            byte[] b = new byte[25];
//            fis.read(b);
//            //当字节数组的长度超过文件中的字节数的时候，按文件中实际的字节数来读，超出范围的数字为默认值0
//            for (int i = 0; i < b.length; i++) {
//                System.out.println(b[i]);
//            }

//            int x;
//            //多次读写，每次仍为一个字节
//            while ((x = fis.read()) != -1) {
//                System.out.println(x);
//            }

            //读取文件,使用i接收数据
//                int i = fis.read();
//                System.out.println(i);
            //继续接收文件 (没有文件情况下继续读取，返回 -1)
//            int j = fis.read();
//            System.out.println(j);
//            int k = fis.read();
//            System.out.println(k);
            //如果读到文件尾，返回-1
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
