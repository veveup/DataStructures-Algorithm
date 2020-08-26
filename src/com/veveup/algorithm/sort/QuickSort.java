package com.veveup.algorithm.sort;

import com.veveup.utils.myUtils;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = myUtils.getArrayIntRandom(80000, 800000);
        arr = new int[]{7, 1, 3, 5, 6};
        myUtils.isSorted(arr);
        myUtils.printNowTime();
        quickSort(arr,0,arr.length-1);
        myUtils.printNowTime();


        myUtils.isSorted(arr);
    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int tmp = 0;
        int pivot = arr[(left+right)/2];
        while (l<r){
            // 在 pivot 左边找到个 大于 pivot的
            while ((arr[l]<pivot)){
                l+=1;
            }
            // 在 pivot 右边找到个 小于 pivot的
            while (arr[r]>pivot){
                r-=1;
            }
            if(l>=r){
                break;
            }
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            if(arr[l] == pivot){
                r--;
            }
            if(arr[r] == pivot){
                l++;
            }
        }
        if(l==r){
            l+=1;
            r-=1;
        }
        if(left<r){
            quickSort(arr,left,r);
        }
        if(right>r){
            quickSort(arr,l,right);
        }
    }
}
