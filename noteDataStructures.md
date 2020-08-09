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



