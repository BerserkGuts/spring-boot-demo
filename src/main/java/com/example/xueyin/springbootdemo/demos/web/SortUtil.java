package com.example.xueyin.springbootdemo.demos.web;

public class SortUtil {


    public static void sort(int[] arr, int type) {
        if (type == 1) {
            bubbleSort(arr);
        } else {
            mergeSort(arr);
        }
    }


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


    // 合并排序方法
    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        int[] tempArray = new int[length];
        mergeSort(array, tempArray, 0, length - 1);
    }

    // 实际执行合并排序的递归方法
    private static void mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, tempArray, left, middle); // 对左侧子数组进行排序
            mergeSort(array, tempArray, middle + 1, right); // 对右侧子数组进行排序
            mergeArrays(array, tempArray, left, middle, right); // 合并两个已排序的子数组
        }
    }

    // 合并两个有序子数组的方法
    private static void mergeArrays(int[] array, int[] tempArray, int left, int middle, int right) {
        // 复制当前要合并的部分到临时数组
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }

        int i = left; // 左侧子数组的开始索引
        int j = middle + 1; // 右侧子数组的开始索引
        int k = left; // 结果数组的开始索引

        // 合并过程
        while (i <= middle && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        // 如果左边还有剩余元素，添加剩余元素
        while (i <= middle) {
            array[k] = tempArray[i];
            k++;
            i++;
        }

        // 注意：右边剩余的元素不需要再复制，因为它们已经在正确的位置上了
    }

    // 测试方法
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Original array:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        mergeSort(array);

        System.out.println("Sorted array:");
        for (int value : array) {
            System.out.print(value + " ");
        }

    }


}
