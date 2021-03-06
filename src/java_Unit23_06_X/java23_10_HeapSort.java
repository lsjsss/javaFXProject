package java_Unit23_06_X;

public class java23_10_HeapSort {
  /** Heap sort method */
  public static <E extends Comparable> void heapSort(E[] list) {
    // Create a Heap of integers
    java23_09_Heap<E> heap = new java23_09_Heap<E>();

    // Add elements to the heap
    for (int i = 0; i < list.length; i++)
      heap.add(list[i]);

    // Remove elements from the heap
    for (int i = list.length - 1; i >= 0; i--)
      list[i] = heap.remove();
  }
  
  /** A test method */
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    heapSort(list);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }
}
