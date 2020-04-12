package javaclass_Binary_IO_Unit17;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class java17_6_TestObjectInputStream {
    public static void main(String[] args)
            throws ClassNotFoundException, IOException {
        try ( // Create an input stream for file object.dat
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("java17_5_TestObjectOutputStream_object.dat"));
                ) {
            // Read a string, double value, and object from the file
            String name = input.readUTF();
            double score = input.readDouble();
            java.util.Date date = (java.util.Date) (input.readObject());
            System.out.println(name + " " + score + " " + date);
        }
    }
}
