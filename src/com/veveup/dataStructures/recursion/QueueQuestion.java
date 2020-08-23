package com.veveup.dataStructures.recursion;

public class QueueQuestion {
    int max = 8;

    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        QueueQuestion queueQuestion = new QueueQuestion();
        queueQuestion.check(0);
        System.out.printf("共有：%d种解法",queueQuestion.count);

    }

    private void  printMap(){
        count++;
        for(int i =0;i<array.length;i++){
            for(int j =0;j<8;j++){
                if(array[i]==j){
                    System.out.printf("x ");
                }else{
                    System.out.printf("0 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean judgeOk(int n){
        for(int i = 0;i<n;i++){
            if(array[i] == array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void check(int n){
        if(n== max){
            printMap();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if(judgeOk(n)){
                // 放置第n+1个皇后
                check(n+1);
            }
            // 若冲突 则继续尝试放置这一行的下一列个皇后
        }
    }
}
