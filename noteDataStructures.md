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



