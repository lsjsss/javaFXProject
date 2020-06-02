package java_Unit23_06_X;

public class java23_06_MergeSort {
    /**
     * �������򷽷�
     * The method for sorting the numbers
     */
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // �ϲ�����ǰ�벿��  Merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            // firstHalf �����д�ŵ��� list ��ǰ 5000 ��Ԫ��
            // �ݹ飺��������������ƺͻع�
            mergeSort(firstHalf);

            // �°���ϲ�����  Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            // secondHalf �����д�ŵ��� list �ĺ� 5000 ��Ԫ��
            // �ݹ�
            mergeSort(secondHalf);

            // ��firstHalf��secondHalf�ϲ����б���  Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    /**
     * �ϲ����������б�
     * Merge two sorted lists
     */
    public static void merge(int[] list1, int[] list2, int[] temp) {
        // list1�еĵ�ǰ����  Current index in list1
        int current1 = 0;
        // list2�еĵ�ǰ����  Current index in list2
        int current2 = 0;
        // ��ǰ�¶�ָ��  Current index in temp
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
     * ���Է���
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
