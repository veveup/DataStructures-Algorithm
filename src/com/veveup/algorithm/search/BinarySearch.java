package com.veveup.algorithm.search;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,5,7,9,10};
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        int i = binarySearch(arr, 0, arr.length - 1, 0);
        System.out.println(i);
    }

    /**
     * 二分查找
     * @param arr   升序数组
     * @param left  左边索引
     * @param right 右边索引
     * @param findVal   要查找的值
     * @return  下标
     */
    public static int binarySearch(int[] arr,int left, int right, int findVal){
        System.out.println("binarySearch Run");
        if(left>right){
            return -1;
        }

        int mid = (left+right)/2;
        int midVal = arr[mid];

        if(findVal > midVal){ // 向右递归
            return binarySearch(arr,mid+1,right,findVal);
        }else if(findVal < midVal){ //向左递归
            return binarySearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }
}
