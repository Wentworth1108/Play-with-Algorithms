package mergeSort;

import insertionSort.InsertionSort;
import util.SortTestHelper;

import java.util.Arrays;

public class MergeSortBU {
    private MergeSortBU() {
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) { // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) { // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else { // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;

        /*for (int sz = 1; sz < n; sz *= 2) {
            for (int i = 0; i < n - sz; i += sz + sz) {
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr, i, i + sz + 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }*/

        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
        for (int i = 0; i < n; i += 16)
            InsertionSort.sort(arr, i, Math.min(i + 15, n - 1));

        for (int sz = 16; sz < n; sz += sz)
            for (int i = 0; i < n - sz; i += sz + sz)
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
    }

    // 测试 MergeSort BU
    public static void main(String[] args) {

        // Merge Sort BU 也是一个O(nlogn)复杂度的算法
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("mergeSort.MergeSortBU", arr);

    }
}
