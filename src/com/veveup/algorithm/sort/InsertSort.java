package com.veveup.algorithm.sort;

import com.veveup.utils.myUtils;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = myUtils.getArrayIntRandom(80000, 80000);
//        System.out.println(Arrays.toString(arr));
        myUtils.isSorted(arr);
        myUtils.printNowTime();
        InsertSort(arr);
        myUtils.printNowTime();
        InsertSortReverse(arr);
        myUtils.printNowTime();

        myUtils.isSorted(arr);
//        System.out.println(Arrays.toString(arr));

    }

    public static void InsertSort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        for (int i=1;i<arr.length;i++){
            insertVal = arr[i];
            insertIndex = i-1;
            while (insertIndex>=0 && arr[insertIndex]>insertVal){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1 != i){
                arr[insertIndex+1] = insertVal;
            }
        }
    }

    public static void InsertSortReverse(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        for (int i=1;i<arr.length;i++){
            insertVal = arr[i];
            insertIndex = i-1;
            while (insertIndex>=0 && arr[insertIndex]<insertVal){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1 != i){
                arr[insertIndex+1] = insertVal;
            }
        }
    }
}
