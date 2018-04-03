package heap;

import util.SortTestHelper;

public class IndexHeapSort {
    private IndexHeapSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        IndexMaxHeap<Comparable> indexMaxHeap = new IndexMaxHeap<>(n);

        for (int i = 0; i < n; i++)
            indexMaxHeap.insert(i, arr[i]);

        for (int i = n - 1; i > 0; i--)
            arr[i] = indexMaxHeap.extractMax();
    }

    // 测试 Index Heap Sort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("heap.IndexHeapSort", arr);
    }
}
