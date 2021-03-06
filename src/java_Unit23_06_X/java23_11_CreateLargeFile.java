package java_Unit23_06_X;

import java.io.*;

public class java23_11_CreateLargeFile {
  public static void main(String[] args) throws Exception {
    DataOutputStream output = new DataOutputStream(
      new BufferedOutputStream(
      new FileOutputStream("largedata.dat")));

    for (int i = 0; i < 800004; i++)
      output.writeInt((int)(Math.random() * 1000000));

    output.close();

    // Display first 100 numbers
    DataInputStream input = 
      new DataInputStream(new FileInputStream("largedata.dat"));
    for (int i = 0; i < 100; i++)
      System.out.print(input.readInt() + " ");

    input.close();
  }
}
