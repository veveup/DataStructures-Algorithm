package com.veveup.dataStructures.stack;

import java.util.Scanner;

public class ArrayStack {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayStackEntry arrayStackEntry = new ArrayStackEntry(5);
        String key = "";
        Boolean loop = true;
        while (loop){
            System.out.println("p(push)");
            System.out.println("g(pop)");
            System.out.println("s(show)");
            System.out.println("e(exit)");
            key = scanner.next();
            switch (key){
                case "p":
                    System.out.println("请输入一个数字：");
                    int v = scanner.nextInt();
                    arrayStackEntry.push(v);
                    break;
                case "g":
                   try {
                       int res = arrayStackEntry.pop();
                       System.out.println("获得的值："+res);
                   }catch (Exception e ){
                       System.out.println(e.getMessage());
                   }
                   break;
                case "s":
                    arrayStackEntry.show();
                    break;
                case "e":
                    loop = false;
                    System.out.println("推出程序");
                    break;
                default:
                    break;
            }
        }

    }
}

class ArrayStackEntry{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStackEntry(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty(){
        return top==-1;
    }

    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满 无法再添加");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空 无法pop");
        }
        int tmp = stack[top];
        top--;
        return tmp;
    }

    //看一下栈
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        return stack[top];
    }

    //打印栈
    public void show(){
        int tmp = top;
        while (tmp>=0){
            System.out.printf("Stack[%d]:\t%d\n",tmp,stack[tmp]);
            tmp--;
        }
    }


}
