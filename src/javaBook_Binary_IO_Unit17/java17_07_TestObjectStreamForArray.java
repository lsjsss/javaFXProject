package javaBook_Binary_IO_Unit17;

import java.io.*;

/**
 * 使用对象流对数组进行读写
 */
public class java17_07_TestObjectStreamForArray {
    public static void main(String[] args)
            //未找到异常  IO异常
            throws ClassNotFoundException, IOException {
        //创建
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"John", "Susan", "Kim"};

        try ( // Create an output stream for file array.dat
              //创建输出流  trye：使用追加方式写入数组
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("java17_7_TestObjectStreamForArray_array.dat", true));
                ) {
            // Write arrays to the object output stream
            //分别写入 整型数组和字符串数组
            output.writeObject(numbers);
            output.writeObject(strings);
        }

        try ( // Create an input stream for file array.dat
              //创建输入流
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("java17_7_TestObjectStreamForArray_array.dat"));
                ) {
            //读取整型数组对象 readObject() 并强制转换类型
            int[] newNumbers = (int[]) (input.readObject());
            String[] newStrings = (String[]) (input.readObject());
            // Display arrays
            //输出数组内容
            for (int i = 0; i < newNumbers.length; i++) {
                System.out.print(newNumbers[i] + " ");
            }
            System.out.println();

            for (int i = 0; i < newStrings.length; i++) {
                System.out.print(newStrings[i] + " ");
            }
        }
    }
}
