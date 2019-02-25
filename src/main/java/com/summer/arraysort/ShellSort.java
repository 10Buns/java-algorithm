package com.summer.arraysort;

import com.summer.util.ArrayUtil;

import java.util.Arrays;

public class ShellSort {

    /**
     * 希尔排序（Wiki官方版）
     *
     * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（注意此算法的gap取值）
     * 2. 按增量序列个数k，对序列进行k 趟排序；
     * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param arr  待排序数组
     */
    public static void shellSort(int[] arr) {
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3)
            gap = gap * 3 + 1;      // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
                System.out.println("Sorting:  " + Arrays.toString(arr));
            }
        }
    }

    /**
     * 希尔排序的原理:根据需求，如果你想要结果从大到小排列，它会首先将数组进行分组，然后将较大值移到前面，较小值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数，可以说希尔排序是加强
     * 版的插入排序
     * 拿数组5, 2, 8, 9, 1, 3，4来说，数组长度为7，当increment为3时，数组分为两个序列
     * 5，2，8和9，1，3，4，第一次排序，9和5比较，1和2比较，3和8比较，4和比其下标值小increment的数组值相比较
     * 此例子是按照从大到小排列，所以大的会排在前面，第一次排序后数组为9, 2, 8, 5, 1, 3，4
     * 第一次后increment的值变为3/2=1,此时对数组进行插入排序，
     * 实现数组从大到小排
     */
    public static void shellSort2(int[] arr) {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < arr.length; i++) {
                temp = arr[i];
                for (j = i; j >= increment; j -= increment) {
                    if(temp > arr[j - increment]){//如想从小到大排只需修改这里
                        arr[j] = arr[j - increment];
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
            }
            System.out.println("Sorting:  " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,20,15,0,6,7,2,1,-5,99,88,71};
        shellSort(arr);
        ArrayUtil.printArr(arr);
    }

}
