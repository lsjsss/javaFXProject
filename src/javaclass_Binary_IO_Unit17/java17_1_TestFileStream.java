package javaclass_Binary_IO_Unit17;

import java.io.*;

public class java17_1_TestFileStream {
    public static void main(String[] args) throws IOException {
        try (
            FileOutputStream output = new FileOutputStream("java17_1_TestFileStream_temp.dat");
            ) {
                for (int i = 1; i <= 10; i++) {
                    output.write(i);
                }
        }

        try (
                FileInputStream input = new FileInputStream("java17_1_TestFileStream_temp.dat");
                ) {
                int value;
                while ((value = input.read()) != -1) {
                    System.out.print(value + " ");
            }
        }
    }
}
