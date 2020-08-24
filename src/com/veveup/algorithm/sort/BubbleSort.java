package com.veveup.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {1,2,3,5,-1,4,10};

        bubbleSort(arr);


        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for(int i =arr.length;i>0;i--){
            for(int j=0;j<i-1;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if(flag==false){  // 若这次循环判断 没有交换 则结束
                System.out.println("不需要再比较了");
                break;
            }
            flag = false;
        }
    }
}
