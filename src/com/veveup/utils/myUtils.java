package com.veveup.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class myUtils {
    private static Date starttime;
    /**
     * 现在时间：2020-08-24 20:17:15-341
     * 若第再次调用 则会打印距上次调用的时间间隔
     * 相隔:11.984s
     */
    public static void printNowTime(){
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss-SSS");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("现在时间："+date1Str);
        if(starttime==null){
            starttime = date1;
        }else{
            long l = date1.getTime() - starttime.getTime();
            if(l>10000){
                System.out.println("相隔:"+l/1000.0+"s");
            }else{
                System.out.println("相隔:"+l+"ms");
            }
            starttime = date1;
        }
    }

    /**
     * 返回一个随机的整数数组
     * @param size 数组长度
     * @param max 数值区间[0,max)
     * @return
     */
    public static int[] getArrayIntRandom(int size,int max){
        int[] arr = new int[size];
        for(int i = 0 ;i<size;i++){
            arr[i] = (int)(Math.random()*max);
        }
        return arr;
    }

    /**
     * 判断int数组是否有序
     * 是升序数组！ / 不是有序数组！
     * @param arr 输入一个数组
     * @return
     */
    public static boolean isSorted(int[] arr){
        boolean flag = true;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("是升序数组！");
            return true;
        }
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                System.out.println("不是有序数组！");
                return false;
            }
        }
        System.out.println("是倒序数组！");
        return true;
    }
}
