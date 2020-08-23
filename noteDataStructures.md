# 数据结构



## 	✅ 稀疏数组 SparseArray

**二维数组转稀疏数组**

1. 稀疏数组用于多数为零或为其他常数的数组
2. 计算数组的长宽和非零或其他常数的数量 赋值给第一行
3. 依次将非零的数字坐标及值添加到稀疏数组

**稀疏数组转二维数组**

1. 还原表原始表的大小
2. 依次将值放回去





## 	✅ 队列 Queue

可以使用数组或链表来实现，front rear 

**addQueue getQueue headQueue isFull isEmpty**

**使用数组模拟队列：** 数组只能使用一次 使用取模的方式将队列变成环形队列

**使用数组模拟环形队列：**

1.  front指向第一个元素 
2. rear指向最后一个元素的后一个位置 
3. 有效数据个数 maxSize-1 
4. (rear+maxsize-front )%maxSize == front 满的
5. front == rear 空的





## 	✅ 链表 Linked List 

#### SingleLinkedList

**不排序链表：** while(tmp.next!=null)  tmp = tmp.next 找到最后一个节点

**排序链表：** 

```java
while(tmp.next!=null){
   if(tmp.next.no<hero.no) hero.next=tmp.next; tmp.next=hero; break;
   tmp = tmp.next;
}
// 再多做些 关于已经存在的flag判断就可以了
```

**修改链表**

```java
while(tmp.next!=null){
	if(tmp.next.no == hero.no) tmp.next.name = hero.name; return;
  // 使用tmp.next 避免了判断头元素 且 不需要再处理最后一个元素的判断
  tmp = tmp.next;
}
// 若运行到这里 则代表没有匹配相同的no
```

**删除节点**

```java
while(tmp.next!=null){
if(tmp.next.no==no) tmp.next = tmp.next.next; return;
  tmp = tmp.next;
}
// 若执行到这里 则代表没有对应no
```

**链长（有效节点个数）**

```java
int counter = 0;
while(head.next!=null){
	counter++;
	head = head.next;
}
// 这里计数的是 是否有下一个节点 若有则计数 所以从head开始 而不是head.next
```

**反转单链表**

```java
reverseHead = new Node();
tmp = head.next
// 这里操作的是节点 本身 所以判断的是 tmp！=null 前面很多操作都是在判断tmp.next
while(tmp!=null){
	// 先取出原来节点的下一个节点 再把这个节点插入新的链表 然后继续遍历下一个节点
	next = tmp.next;
	tmp.next = reverseHead.next;
	reverserHead.next = tmp;
	tmp = next;
}
head = reverseHead;
// 主要思想是 新建一个链表 然后遍历原来链表 将每个节点依次插入新建表的头部（reaverseHead和 第一个节点之间） 最后head取代reverseHead 达到了反转
```

**从尾到头打印单链表**

```java
1. 使用栈 Stack 的结构
	这种方式比较简单 创建个栈的结构 然后遍历整个单链表 将节点一个一个压入栈 最后迭代栈打印出来
2. 递归调用 使用系统的栈 遇到了链表尾部 才打印返回
public static void reversetPrintList(Node node){
	if(node.next!=null){
		reversetPrintList(node.next);
		print(node);
		return;
	}else{
		print(node);
		return
	}
}
```



#### DoubleLinkedList

**节点 Node**

```java
class Node{
	int No;
	Node pre;
	Node next;
}
```

**删除链表**

```java
while(tmp!=null){
	if(tmp.no==no){
		tmp.pre.next = tmp.next;
		// 若为最后一个节点 则不需要
		if(tmp.next!=null){
			tmp.next.pre = tmp.pre;
		}
	}
}
```



#### CircleSingleLinkedList 单向环形链表

```java
class CircleSingleLinkedListEntry{
	Node first = null; // 环的头指针 当第一次添加时 先将这个取代掉
	Node curBoy = null; //这个是个指针 指向最后一个节点 来标示环的结尾
}
```

**显示**

```java
Node tmp = first;
// 这里使用do while 是为了能使表达式为 tmp！=first 的时候 可以多执行一次 将最后一个节点打印
do{
	print(tmp);
	tmp = tmp.next;
}while(tmp!=first);
```

**约瑟夫问题 Josephu**

```java
// 借助一个节点 放在 当前移动到节点前面 用于移除当前节点 并连接起来
Node helper = null;
whiel(helper.next!=first) hlper = helper.next

// 移动到开始位置
for(int i=1; i<startNo;i++) first = first.next; helper = helper.next;

do{
	for(int j = 0; j < stepNum-1 ; j++) first = first.next; helper = helper.next;
	// 现在first已经指向了出队节点 移除他
	print("出队节点"+first);
	first = first.next;
	hlper.next = first;
}while(first.next!=first)
// 若只剩最后一个节点了 则不再出队 但此时 链表中还有最后一个节点
```





## ✅ 栈 Stack

可以使用数组简单实现栈的结构 只需要使用一个 pop作为指针 记录栈当前的位置<br>也可以使用SingleLinkedList实现 栈顶 一直指向 head/first 可以简单实现 push pop 操作

**中缀表达式的计算** 不支持括号

```java

1. 遍历整个表达式
2. 若当前表达式是数字存入数字缓存（适配多位数字）
3. 遇到操作符 先将数字压入数字栈 然后判断符号栈是否有符号
  1.若没有符号 则直接压入
  2.有符号 判断符号优先级 若栈中符号优先级高 则取出两个数字 和 一个操作符计算之
  3.将计算结果 和 当前符号各压入栈中
4. 表达式遍历完 将最后一个数字压入数字栈
5. 根据 符号栈是否为空 循环取出两个数 一个操作符 计算结果压入数字栈
6. 退出循环 数字栈中的既为最后结果
// 扩展一个普通栈的功能 增加计算器相关方法
class CalculatorStack Extends ArraryStackEntry{
	//判断符号优先级
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
        switch (oper)
            case '+':res = num1+num2;
            case '-':res = num2-num1;
            case '*':res = num1*num2;
            case '/':res = num2/num1;
        return res;
    }
}
```

**后缀表达式计算 逆波兰表达式**

```java
// 将表达式转为 List 然后循环遍历List
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
```

**中缀表达式转后缀表示**

```java
Stack<String> s1 = new Stack<>();
List<String> s2 = new ArrayList<>();
for(String s:list){
  if(s.matches("\\d+")){
    s2.add(s); 			//结果栈
  }else if(s.equals("(")){
    s1.push("(");
  }else if(s.equals(")")){
    while (!s1.peek().equals("(")){
      s2.add(s1.pop());
    }
    s1.pop();     // 弹出 左 括号
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
print(s2);
```

## ✅ 递归 Recursion

底层使用了栈的结构，每个空间中的局部变量是独立的 这容易混淆，引用类型 是共享的数据

 **简单迷宫问题**

```java
// 利用递归可以回溯的特性 路径走不通的时候 就返回
public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j]==0){
                map[i][j] = 2;
                if(setWay(map,i+1,j)){
                    return true;
                }else if(setWay(map,i,j+1)){
                    return true;
                }else if(setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
```

**八皇后问题**

```java
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
```

