package com.summer.util;

import java.util.Random;

public class ArrayUtil {

    /**
     * 随机生成数组
     * @param length
     * @return
     */
    public static int[] initArr(int length){
        if (length <= 0){
            return new int[0];
        }

        int[] arr = new int[length];
        for(int i=0;i<length;i++){
            int value = (int)(Math.random()*100);
            arr[i] = value;
        }
        return arr;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArr(int[] arr) {
        System.out.println("===开始打印===");
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length ; i ++ ){
            sb.append(arr[i]).append(",");
        }
        String str = sb.substring(0, sb.length()-1);
        System.out.println(str);
        System.out.println("===结束打印===");
    }

}
