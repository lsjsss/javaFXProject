package javaclass_Binary_IO_Unit17;

import java.io.*;

public class java17_7_TestObjectStreamForArray {
    public static void main(String[] args)
            throws ClassNotFoundException, IOException {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"John", "Susan", "Kim"};

        try ( // Create an output stream for file array.dat
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("java17_7_TestObjectStreamForArray_array.dat", true));
                ) {
            // Write arrays to the object output stream
            output.writeObject(numbers);
            output.writeObject(strings);
        }

        try ( // Create an input stream for file array.dat
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("java17_7_TestObjectStreamForArray_array.dat"));
                ) {
            int[] newNumbers = (int[]) (input.readObject());
            String[] newStrings = (String[]) (input.readObject());
            // Display arrays
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
