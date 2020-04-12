package javaclass_Binary_IO_Unit17;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class java17_5_TestObjectOutputStream {
    public static void main(String[] args) throws IOException {
        try ( // Create an output stream for file object.dat
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("java17_5_TestObjectOutputStream_object.dat"));
                ) {
            // Write a string, double value, and object to the file
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeObject(new java.util.Date());
        }
    }
}
