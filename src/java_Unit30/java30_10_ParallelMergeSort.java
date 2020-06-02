package java_Unit30;

import java_Unit23_06_X.java23_06_MergeSort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 排序 - 合并排序 - 并行合并排序；
 * 排序方式： 选择法、冒泡法、二分法
 */
public class java30_10_ParallelMergeSort {
    public static void main(String[] args) {
        final int SIZE = 7000000;
        int[] list1 = new int[SIZE];
        int[] list2 = new int[SIZE];

        for (int i = 0; i < list1.length; i++) {
            list1[i] = list2[i] = (int) (Math.random() * 10000000);
        }

        long startTime = System.currentTimeMillis();
        // 调用并行合并排序  Invoke parallel merge sort
        parallelMergeSort(list1);
        long endTime = System.currentTimeMillis();
        System.out.println("\n与平行时间 Parallel time with "
                + Runtime.getRuntime().availableProcessors() +
                " 处理器是 processors is " + (endTime - startTime) + " 毫秒 milliseconds");

        startTime = System.currentTimeMillis();
        // MergeSort is in Listing 24.5
        java23_06_MergeSort.mergeSort(list2);
        endTime = System.currentTimeMillis();
        System.out.println("\n顺序时间是 Sequential time is " +
                (endTime - startTime) + " 毫秒 milliseconds");
    }

    public static void parallelMergeSort(int[] list) {
        RecursiveAction mainTask = new SortTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class SortTask extends RecursiveAction {
        private final int THRESHOLD = 500;
        private int[] list;

        SortTask(int[] list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if (list.length < THRESHOLD) {
                java.util.Arrays.sort(list);
            } else {
                // 获取上半年  Obtain the first half
                int[] firstHalf = new int[list.length / 2];
                System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

                // 获得下半场  Obtain the second half
                int secondHalfLength = list.length - list.length / 2;
                int[] secondHalf = new int[secondHalfLength];
                System.arraycopy(list, list.length / 2,
                        secondHalf, 0, secondHalfLength);

                // 递归地将两半排序  Recursively sort the two halves
                invokeAll(new SortTask(firstHalf),
                        new SortTask(secondHalf));

                // 将firstHalf和secondHalf合并到列表中  Merge firstHalf with secondHalf into list
                java23_06_MergeSort.merge(firstHalf, secondHalf, list);
            }
        }
    }
}
