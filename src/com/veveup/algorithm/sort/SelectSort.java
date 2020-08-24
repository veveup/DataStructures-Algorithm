package com.veveup.algorithm.sort;

import com.veveup.utils.myUtils;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = myUtils.getArrayIntRandom(80000,4000000);
        myUtils.printNowTime();
        selectSort(arr);
        myUtils.printNowTime();
//        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr){
        int min = 0;
        int minIndex = 0;
        for(int i = 0; i<arr.length-1 ;i++){
            min = arr[i];
            minIndex = i;
            for (int j = i ; j < arr.length; j++) {
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
    }
