package com.veveup.algorithm.sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,-1,4,10};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        //定义一个二维数组 十个桶
        int[][] bucket = new int[10][arr.length];

        // 每个桶的指针
        int[] bucketPoints = new int[10];

        int maxLength = (max + "").length();

        for (int c = 0,n=1; c < maxLength; c++,n*=10) {
            int digitOfElement;

            for (int i = 0; i < arr.length; i++) {
                // 取出每个元素的个位
                digitOfElement = arr[i] /n % 10;
                bucket[digitOfElement][bucketPoints[digitOfElement]++] = arr[i];
            }

            int index = 0;
            for (int i = 0; i < bucketPoints.length; i++) {
                for (int j = 0; j < bucketPoints[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
                bucketPoints[i] = 0;
            }
        }
    }
}
