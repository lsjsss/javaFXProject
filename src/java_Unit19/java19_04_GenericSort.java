package java_Unit19;

public class java19_04_GenericSort {
    public static void main(String[] args) {
        // Create an Integer array
        //����һ�� Integer ��������
        Integer[] intArray = {new Integer(2), new Integer(4),
                new Integer(3)};

        // Create a Double array
        //����һ��Double��������
        Double[] doubleArray = {new Double(3.4), new Double(1.3),
                new Double(-22.1)};

        // Create a Character array
        //����һ���ַ����͵�����
        Character[] charArray = {new Character('a'),
                new Character('J'), new Character('r')};

        // Create a String array
        //����һ���ַ�������
        String[] stringArray = {"Tom", "Susan", "Kim"};

        // Sort the arrays
        //��һ�γ��򣬶�����������������
        //�������ĸ�����(ʹ�÷���)
        sort(intArray);
        sort(doubleArray);
        sort(charArray);
        sort(stringArray);

        // Display the sorted arrays
        //��������������飬ʹ��ͬһ�ַ������(ʹ�÷���)
        System.out.print("Sorted Integer objects: ");
        printList(intArray);
        System.out.print("Sorted Double objects: ");
        printList(doubleArray);
        System.out.print("Sorted Character objects: ");
        printList(charArray);
        System.out.print("Sorted String objects: ");
        printList(stringArray);
    }

    /**
     * Sort an array of comparable objects
     * ���� E ���Ͷ�����бȽ�(ͬһ���ͽ��бȽ�)��
     * E �� Comparable �������ͣ�
     * ָ�����бȽϵ�Ԫ���� E ���ͣ�
     * �ɱȽ϶������������
     */
    public static <E extends Comparable<E>> void sort(E[] list) {//���ͷ��������޵ķ���
        //���� E ��һ������(��Сֵ)
        E currentMin;

        //�������͵���Сֵ���±�
        int currentMinIndex;

        //˫��ѭ���������������
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i+1..list.length?2]
            currentMin = list[i];
            currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    /**
     * Print an array of objects
     */
    public static void printList(Object[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}

