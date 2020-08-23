package com.veveup.dataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
//        String suffixExpression = "3 4 + 5 * 6 -";
//
//        List<String> rList = getListString(suffixExpression);
//        System.out.println("list"+rList);
//
//        int res  = calculate(rList);
//
//        System.out.println("计算结果："+res);

        String expression = "1+((2+3)*4)-5";
        List<String> list = string2InfixExpressionList(expression);
        System.out.println(list);
        List<String> strings = infix2Suffix(list);
        System.out.println(strings);
        int calculate = calculate(strings);
        System.out.println(calculate);


    }

    public static List<String> infix2Suffix(List<String> list){
        Stack<String> s1 = new Stack<>();
//        Stack<String> s2 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        for(String s:list){
            if(s.matches("\\d+")){
                s2.add(s);
            }else if(s.equals("(")){
                s1.push("(");
            }else if(s.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                // 弹出 左 括号
                s1.pop();
            }else{
                while (s1.size()!=0 && Operation.getValue(s1.peek())>= Operation.getValue(s)){
                    s2.add(s1.pop());
                }
                s1.push(s);
            }
        }

        while(s1.size()!=0){
            s2.add(s1.pop());
        }

        return s2;

    }

    public static List<String> string2InfixExpressionList(String s){
        List<String> list = new ArrayList<>();
        int index = 0;
        String tmp ="";
        char ch;
        do {
            ch = s.charAt(index);
            if(ch<48||ch>57){
                list.add(""+ch);
                index++;
            }else {
                tmp = "";
                while(index < s.length() && (ch=s.charAt(index))>=48 &&(ch=s.charAt(index))<=57){
                    tmp +=ch;
                    index++;
                }
                list.add(tmp);
            }
        }while (index<s.length());
        return list;
    }

    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for(String i:split){
            list.add(i);
        }
        return list;
    }
    
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if(item.matches("\\d+")){
                stack.push(item);
            }else{
                int pop = Integer.parseInt(stack.pop());
                int  pop1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = pop+pop1;
                }else if(item.equals("-")){
                    res = pop1 - pop;
                }else if(item.equals("*")){
                    res = pop*pop1;
                }else if(item.equals("/")){
                    res = pop1 / pop;
                }else {
                    throw new RuntimeException("表达式错误");
                }
                stack.push(res+"");
            }
            
        }

        return Integer.parseInt(stack.pop());
    }
}



class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
        }
        return result;
    }
}