package com.veveup.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,7,6,8};

        int[] temp = new int[arr.length];

        mergeSort(arr,0,arr.length-1,temp);

        System.out.println(Arrays.toString(arr));


    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            // 向左递归进行分解
            mergeSort(arr,left,mid,temp);
            // 向右递归进行分解
            mergeSort(arr,mid+1,right,temp);

            merge(arr,left,mid,right,temp);
        }
    }


    /**
     * 合并的方法
     * @param arr 排序的原始数组
     * @param left 分治开始
     * @param mid 中间索引 用来区分左右
     * @param right 分治结束
     * @param temp 中转数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left; //
        int j = mid+1;
        int t = 0; // 指向temp数组的当前索引

        // 先把左右两边数据 拷贝到temp数组
        // 直到 两边有序序列 有一边处理完成
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t] = arr[i];
                i++;
            }else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }

        // 有剩余数据的一边 全部拷贝到temp数组
        while(i<=mid){
            temp[t] = arr[i];
            t++;
            i++;
        }

        while(j<=right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //将temp数组元素拷贝回原数组
        t = 0;
        i=left;
        while (i<=right){
            arr[i]=temp[t];
            t++;
            i++;
        }

    }
}
