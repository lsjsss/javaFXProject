package javaclass_Binary_IO_Unit17;

import java.io.*;

public interface java17_2_TestDataStream {
    public static void main(String[] args) throws IOException {
        try (
                DataOutputStream output = new DataOutputStream(new FileOutputStream("java17_1_TestFileStream_temp.dat"));
                ) {
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("George");
            output.writeDouble(105.25);
        }

        try (
                DataInputStream input = new DataInputStream(new FileInputStream("java17_1_TestFileStream_temp.dat"));
                ) {
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
}