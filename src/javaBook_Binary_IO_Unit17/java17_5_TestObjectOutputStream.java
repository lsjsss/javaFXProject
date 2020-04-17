package javaBook_Binary_IO_Unit17;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/** �������������������д(���)����writeObject() */
public class java17_5_TestObjectOutputStream {
    /** �������׳��쳣 */
    public static void main(String[] args) throws IOException {
        try ( // Create an output stream for file object.dat
              //����һ�����������  ����Ӧ����һ���ļ������ "objet.dat"
              ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("java17_5_TestObjectOutputStream_object.dat"));
                ) {
            // Write a string, double value, and object to the file
            //д��������ݣ�д�ַ�����д��������
            output.writeUTF("John");
            output.writeDouble(85.5);
            //д����������� java.util.Date()
            //DataOutputStream
            //writeUTF()  writeDouble() ��Щ�������� DataInput �ӿ���
            //ObjetOutputStream ��ʵ���� ObjectInput ����ӿ�,��ObjectInput ����ӿ���DataInput�ӿڵ��ӽӿ�
            output.writeObject(new java.util.Date());

            System.out.println("������ļ����");
        }
    }
}
