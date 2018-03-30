package insertionSort;

import util.SortTestHelper;

public class InsertionSort {

    // 该算法不允许产生任何实例
    private InsertionSort() {}

    // 对整个arr数组使用InsertionSort排序
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            /*for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j-1]) < 0)
                    swap(arr, j, j-1);
                else
                    break;
            }*/

            // simplify
            /*for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--)
                swap(arr, j, j-1);*/

            // advance
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j-1].compareTo(arr[j]) > 0; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 0 && arr[j-1].compareTo(arr[j]) > 0; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试InsertionSort
    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("insertionSort.InsertionSort", arr);

    }

}
