package com.veveup.algorithm.search;

public class SeqSearch {

    // 查找到第一个值 返回
    public static int seqSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
