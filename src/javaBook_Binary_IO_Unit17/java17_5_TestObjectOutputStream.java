package javaBook_Binary_IO_Unit17;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/** 对象输出流，向流里面写(输出)对象，writeObject() */
public class java17_5_TestObjectOutputStream {
    /** 主方法抛出异常 */
    public static void main(String[] args) throws IOException {
        try ( // Create an output stream for file object.dat
              //创建一个对象输出流  参数应该是一个文件输出流 "objet.dat"
              ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("java17_5_TestObjectOutputStream_object.dat"));
                ) {
            // Write a string, double value, and object to the file
            //写入对象数据，写字符串，写基本类型
            output.writeUTF("John");
            output.writeDouble(85.5);
            //写入日期类对象 java.util.Date()
            //DataOutputStream
            //writeUTF()  writeDouble() 这些方法是在 DataInput 接口中
            //ObjetOutputStream 类实现了 ObjectInput 这个接口,而ObjectInput 这个接口是DataInput接口的子接口
            output.writeObject(new java.util.Date());

            System.out.println("输出到文件完成");
        }
    }
}
