package com.veveup.algorithm.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {

        int[] arr = {1,2,3,5,7,9,10};
        System.out.println(fibSearch(arr,7));

    }

    public static int fibSearch(int[] a,int key){
        int low = 0;
        int high = a.length-1;

        int mid = 0;
        int k = 0;
        // fib 数列 下标

        int[] fib = fib();

        // 匹配arr长度的fib
        while (high>fib[k]-1){
            k++;
        }

        //将arr扩充到fib的长度 并后面填最高位
        int[] temp = Arrays.copyOf(a,fib[k]);
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        while (low<=high){
            mid = low+fib[k-1]-1;
            if(key<temp[mid]){
                high = mid-1;
                k--;
            }else if(key>temp[mid]){
                low = mid+1;
                k-=2;
            }else{
                if(mid<=high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;

}

    /**
     * 返回fibonacci数列
     * @return
     */
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0]=1;f[1]=1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }
}
