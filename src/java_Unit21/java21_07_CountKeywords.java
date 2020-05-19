package java_Unit21;

import java.util.*;
import java.io.*;

public class java21_07_CountKeywords {
  /** ������δ�����쳣�� �����׳��쳣�� JVM */
  public static void main(String[] args) throws Exception {  
    Scanner input = new Scanner(System.in);
    System.out.print("����JavaԴ�ļ�  Enter a Java source file: ");
    String filename = input.nextLine();

    // ��װ  �ļ�����������
    File file = new File(filename);
    if (file.exists()) {
      System.out.println("�еĹؼ�����  The number of keywords in " + filename
        + " is " + countKeywords(file));
    }
    else {
      System.out.println("File " + filename + " does not exist");
      // �˳� java �����
      System.exit(0);
    }
  }

  /** ���쳣�׸� main ���� */
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

    // ����б���
    System.out.println(keywordString.length);

    // �������Ϊ���Ա�
    Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
    int count = 0;    

    // ��η�װ���𲽷�װ    �ַ�������(��������) -> ArrayList -> HashSet(contain()) Ч�ʸ�
    // �ļ�����
    Scanner input = new Scanner(file);

    while (input.hasNext()) {
      // �������� nextLine()�� next Ϊ��ȡһ������
      String word = input.next();
      // ���ҵ�����Ԫ�أ� ������һ
      if (keywordSet.contains(word)) {
        count++;
      }
    }
    return count;
  }
}
