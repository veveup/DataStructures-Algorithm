package com.veveup.dataStructures.queue;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        ArrayQueueEntry arrayQueueEntry = new ArrayQueueEntry(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show)");
            System.out.println("e(exit)");
            System.out.println("a(add)");
            System.out.println("g(get)");
            System.out.println("h(head)");
            key  = scanner.next().charAt(0); //接收一个字符
            switch (key){
                case 's':
                    arrayQueueEntry.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int i = scanner.nextInt();
                    arrayQueueEntry.addQueue(i);
                    break;
                case 'g':
                    try {
                        int res = arrayQueueEntry.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueueEntry.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序推出");

    }
}

class ArrayQueueEntry{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    // 创建队列构造器

    public ArrayQueueEntry(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部， 指向队列头的前一个位置
        rear = -1; // 指向队尾， 指向队尾的数据（队列最后一个数据）
    }

    // 判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    // 添加数据到队列
    public void addQueue(int n){
        // 判断是否满
        if(isFull()){
            System.out.println("队列满");
            return;
        }
        rear++;
        arr[rear]=n;
    }

    // 出队列
    public int getQueue(){
        // 判断是否空
        if(isEmpty()){
//            System.out.println("队列为空！");
            throw  new RuntimeException("队列为空！");
        }
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue(){
        int tmp = front;
        while(tmp<rear){
            tmp++;
            System.out.printf("%d\t",arr[tmp]);
        }
        System.out.println();
    }

    // 显示队列的头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空 不能看数据");
        }
        return arr[front+1];
    }

    //
}
