package java_Unit21;

import java.util.*;
import java.io.*;

public class java21_07_CountKeywords {
  /** 主方法未处理异常， 而是抛出异常到 JVM */
  public static void main(String[] args) throws Exception {  
    Scanner input = new Scanner(System.in);
    System.out.print("输入Java源文件  Enter a Java source file: ");
    String filename = input.nextLine();

    // 封装  文件对象做参数
    File file = new File(filename);
    if (file.exists()) {
      System.out.println("中的关键字数  The number of keywords in " + filename
        + " is " + countKeywords(file));
    }
    else {
      System.out.println("File " + filename + " does not exist");
      // 退出 java 虚拟机
      System.exit(0);
    }
  }

  /** 将异常抛给 main 方法 */
  public static int countKeywords(File file) throws Exception {  
    // Array of all Java keywords + true, false and null
    String[] keywordString = {"abstract", "assert", "boolean", 
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int", 
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static", 
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};

    // 输出列表长度
    System.out.println(keywordString.length);

    // 把数组变为线性表
    Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
    int count = 0;    

    // 多次封装，逐步封装    字符串数组(创建方便) -> ArrayList -> HashSet(contain()) 效率高
    // 文件输入
    Scanner input = new Scanner(file);

    while (input.hasNext()) {
      // 不可以用 nextLine()， next 为读取一个单词
      String word = input.next();
      // 查找到包含元素， 计数加一
      if (keywordSet.contains(word)) {
        count++;
      }
    }
    return count;
  }
}
