package java_Unit30;

import java.util.concurrent.*;

public class java30_03_ExecutorDemo {
    public static void main(String[] args) {
        // ���������������̵߳Ĺ̶��̳߳�  Create a fixed thread pool with maximum three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // �������������ύ��ִ����  Submit runnable tasks to the executor
        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNum(100));

        // �ر�ִ����  Shut down the executor
        executor.shutdown();
    }
}
/**
 * ���ִ��Ч�ʣ����̷߳ŵ��̳߳أ�
 * 1.�����̳߳أ�ʹ�� Executors.newFixedThreadPool() �����̳߳أ�
 * 2.���̷߳ŵ��̳߳��У�exe: ִ�У�
 * 3.�ر��̳߳أ�
 */

