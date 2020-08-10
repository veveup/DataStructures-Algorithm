package com.veveup.dataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";

        List<String> rList = getListString(suffixExpression);
        System.out.println("list"+rList);

        int res  = calculate(rList);

        System.out.println("计算结果："+res);
        
        
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
