package com.veveup.dataStructures.queue;

import java.util.Scanner;

public class ArrayQueueLoop {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4);
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
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int i = scanner.nextInt();
                    circleArray.addQueue(i);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
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

class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    // 创建队列构造器

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0; //指向队列头部， 指向队列的第一个元素
        rear = 0; // 指向队尾， 指向队尾的最后一个数据
    }

    // 判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
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

        arr[rear]=n;
        rear=(rear+1)%maxSize;// 将rear后移 必须考虑取模
    }

    // 出队列
    public int getQueue(){
        // 判断是否空
        if(isEmpty()){
            throw  new RuntimeException("队列为空！");
        }
        int value =  arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue(){
        int tmp = front;
        // 思路：从 front 开始遍历 遍历多少个元素
        for(int i = front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
        System.out.println();
//        while(tmp<rear){
//            tmp++;
//            System.out.printf("%d\t",arr[tmp]);
//        }
//        System.out.println();
    }

    // 求出队列有效的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    // 显示队列的头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空 不能看数据");
        }
        return arr[front];
    }

    //
}
