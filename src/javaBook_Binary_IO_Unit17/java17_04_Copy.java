package javaBook_Binary_IO_Unit17;

import java.io.*;//导入 I/O包中所有的类，占用资源要多一些

public class java17_04_Copy { //提供两个命令行参数，源文件，目标文件
    //多行注释，可以生成文档，增加程序的可读性
    /**
     * Main method
     @param args[0] for sourcefile (源文件名)
     @param args[1] for target file (目标文件名)
     */
    public static void main(String[] args) throws IOException {
        // Check command−line parameter usage
        // 检查命令行参数格式用法是否正确
        if (args.length != 2) {
            System.out.println("Usage: java Copy sourceFile targetfile");
            //退出JVM
            System.exit(1);
        }

        // Check if source file exists
        // 检查源文件是否存在
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            // 退出JVM
            System.exit(2);
        }

        // Check if target file exists
        // 检查目标文件是否存在
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + args[1] + " already exists");
            System.exit(3);
        }
        // 一般来说，这样的检查是必不可少的，一般放在正式代码的前面
        try (
                // Create an input stream
                //创建了一个输入流，使用缓冲区，带缓冲的BufferedInputStream  字节流BufferedInputStream   源文件对象FileInputStream
                BufferedInputStream input =
                        new BufferedInputStream(new FileInputStream(sourceFile));
                // Create an output stream
                BufferedOutputStream output =
                        new BufferedOutputStream(new FileOutputStream(targetFile));
                ) {
            // Continuously read a byte from input and write it to output
            int r, numberOfBytesCopied = 0;
            while ((r = input.read()) != -1) {
                output.write((byte) r);
                numberOfBytesCopied++;
            }

            // Display the file size
            System.out.println(numberOfBytesCopied + " bytes copied");
        }
    }
}
