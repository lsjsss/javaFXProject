package javaclass_Binary_IO_Unit17;

import java.io.*;

public class java17_3_DetectEndOfFile {
    public static void main(String[] args) {
        try {
            try (
                    DataOutputStream output = new DataOutputStream(new FileOutputStream("java17_3_DetectEndOfFile_test.dat"))
                    ) {
                output.writeDouble(4.5);
                output.writeDouble(43.25);
                output.writeDouble(3.2);
            }

            try (
                    DataInputStream input = new DataInputStream(new FileInputStream("java17_3_DetectEndOfFile_test.dat"))
                    ) {
                while (true) {
                    System.out.println(input.readDouble());
                }
            }
        }
        catch (EOFException ex) {
            System.out.println("All data were read");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
