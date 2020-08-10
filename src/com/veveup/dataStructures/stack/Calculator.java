package com.veveup.dataStructures.stack;

public class Calculator {
    public static void main(String[] args) {
        String expr = "13+20*6-1";
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack operStack = new CalculatorStack(10);
        int index = 0; // 遍历表达式的指针
        int num1 = 0; // 计算过程中 pop 的第一个数
        int num2 = 0; // 计算过程中 pop 的第二个数
        int oper = 0; // 操作符号
        char ch = ' '; // 当前遍历表达式的字符
        int res = 0; // 当前计算的值
        String tmpNum = ""; // 存储多位数 的 字符串
        // 遍历整个表达式
        while (index<expr.length()){
            ch = expr.substring(index,index+1).charAt(0);
            // 当前表达式 是 符号还是数字
            if(operStack.isOper(ch)){
                // 是符号的话 先讲 数字压入栈 然后情况存储数字的字符串
                numStack.push(new Integer(tmpNum));
                tmpNum="";
                // 判断 操作符的栈 是否为空 若为空 则直接压入
                if(operStack.isEmpty()){
                    operStack.push(ch);
                }else{
                    // 判断当前操作符的优先级是否要低于栈中的 若 低于则将栈中的计算了 再将当前表达式压入栈内
                    if(operStack.pripority(ch)<=operStack.pripority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else{
                        // 优先级高 则 直接压入栈
                        operStack.push(ch);
                    }
                }
            }else{
                // 若遇到数字 则存入到缓存中
//                numStack.push(ch-'0');
                tmpNum+=ch;
            }
            index++;
        }
        // 将最后一个数字 压入数字栈中
        numStack.push(new Integer(tmpNum));
        // 再将栈中的表达式 依次计算完成
        // 当字符栈只剩一个数字时 既 为结果 当尝试再次出栈时 报错
        try{
            // 当然这里也可以使用 operStack.isEmpty() 判断
            while (!numStack.isEmpty()){
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = numStack.cal(num1,num2,oper);
                numStack.push(res);
            }
        }catch (RuntimeException e){
            System.out.println("计算结果："+num1);
        }

        System.out.println("结束了");
        numStack.show();
        operStack.show();

    }
}

// 扩展ArrayStackEntry的功能 增加计算器的相关方法
class CalculatorStack extends ArrayStackEntry{


    public CalculatorStack(int maxSize) {
        super(maxSize);
    }

    //判断符合优先级
    public int pripority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+'|| oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(int val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res = num2-num1;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}
