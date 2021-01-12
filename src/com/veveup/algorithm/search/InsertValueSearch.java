package com.veveup.algorithm.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        int i = InserValueSearch(arr, 0, arr.length - 1, 0);
        System.out.println(i);


    }

    /**
     * 差值查找 优化过的二分查找 分布均匀的情况下 可以优化查找过程
     * @param arr   升序数组
     * @param left  左边索引
     * @param right 右边索引
     * @param findVal   要查找的值
     * @return  下标
     */
    public static int InserValueSearch(int[] arr,int left, int right, int findVal){
        System.out.println("InserValueSearch Run");
        if(left>right||findVal<arr[0]||findVal>arr[arr.length-1]){
            return -1;
        }

        int mid = left + (right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal = arr[mid];

        if(findVal > midVal){ // 向右递归
            return InserValueSearch(arr,mid+1,right,findVal);
        }else if(findVal < midVal){ //向左递归
            return InserValueSearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }
}
