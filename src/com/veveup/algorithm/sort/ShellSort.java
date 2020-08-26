package com.veveup.algorithm.sort;

import com.veveup.utils.myUtils;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = myUtils.getArrayIntRandom(80000, 800000);
        myUtils.isSorted(arr);
        myUtils.printNowTime();
        ShellSort2(arr);
        myUtils.printNowTime();
        myUtils.isSorted(arr);

    }

    public static void ShellSort(int[] arr){
        int tmp = 0;
        for(int step = arr.length/2;step>0;step = step/2){
            for(int i = step;i<arr.length;i++){
                for(int j=i-step;j>=0;j-=step){
                    if(arr[j] > arr[j+step]){
                        tmp = arr[j];
                        arr[j] = arr[j+step];
                        arr[j+step] = tmp;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
    }

    public static void ShellSort2(int[] arr){
        for(int step=arr.length/2;step>0;step /= 2){
            for(int i = step;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j]< arr[j-step]){
                    while (j-step>=0 && temp<arr[j-step]){
                        arr[j] = arr[j-step];
                        j-=step;
                    }
                }
                arr[j] = temp;
            }
        }
    }
}
