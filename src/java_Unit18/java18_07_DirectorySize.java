package java_Unit18;

import java.io.File;
import java.util.Scanner;

public class java18_07_DirectorySize {
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();
        // Display the size
        System.out.println(getSize(new File(directory)) + " bytes");
    }

    public static long getSize(File file) {
        // Store the total size of all files
        long size = 0;
        if (file.isDirectory()) {
            // All files and subdirectories
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++) {
                // Recursive call
                size += getSize(files[i]);
            }
        } else {
            // Base case
            size += file.length();
        }
        return size;
    }

}
