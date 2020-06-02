package java_Unit23_06_X;

public class java23_06_MergeSort {
    /**
     * 数字排序方法
     * The method for sorting the numbers
     */
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // 合并排序前半部分  Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            // firstHalf 数组中存放的是 list 的前 5000 个元素
            // 递归：自身调用自身，递推和回归
            mergeSort(firstHalf);

            // 下半年合并排序  Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            // secondHalf 数组中存放的是 list 的后 5000 个元素
            // 递归
            mergeSort(secondHalf);

            // 将firstHalf和secondHalf合并到列表中  Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * 合并两个排序列表
     * Merge two sorted lists
     */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        // list1中的当前索引  Current index in list1
        int current1 = 0;
        // list2中的当前索引  Current index in list2
        int current2 = 0;
        // 当前温度指数  Current index in temp
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }

        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }

        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }

    /**
     * 测试方法
     * A test method
     */
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
