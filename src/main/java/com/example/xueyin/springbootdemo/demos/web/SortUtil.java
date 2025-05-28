package com.example.xueyin.springbootdemo.demos.web;

public class SortUtil {

        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // 交换 arr[j] 和 arr[j+1]
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }
                // 如果在某次遍历中没有发生交换，说明数组已经有序，可以提前结束
                if (!swapped) break;
            }
        }


}
