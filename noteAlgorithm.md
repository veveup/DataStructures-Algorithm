# 算法 Algorithm

## ✅ 排序 Sort

**冒泡排序 BubbleSourt**

```java
// 取个指针 从头每次比较当前指针和后一个数比较 若后面数小则交换
// 指针后移一位 再比较 直到指针到=n-1 时结束比较交换 则这个时候得到了最大的数在最后一个
// 再从头比较 到指针=n-2时就结束比较 
// 结论 ： 最多需要循环比较n-1次 每次交换平均值n/2
// 时间复杂度 O(n^2)
public static void bubbleSort(int[] arr){
    int temp = 0;
    boolean flag = false;
    for(int i =arr.length;i>0;i--){
        for(int j=0;j<i-1;j++){
            if(arr[j]>arr[j+1]){
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                flag = true;
            }
        }
        if(flag==false){  // 若这次循环判断 没有交换 则结束
            System.out.println("不需要再比较了");
            break;
        }
        flag = false;
    }
}
```

**选择排序**

```java
// 找出最小的数 然后和第一个位置交换
// 找出第二个小的数 和第二个位置交换
// 直到 n-1 个数
public static void selectSort(int[] arr){
    int min = 0;
    int minIndex = 0;
    for(int i = 0; i<arr.length-1 ;i++){
        min = arr[i];
        minIndex = i;
        for (int j = i ; j < arr.length; j++) {
            if(min > arr[j]){
                min = arr[j];
                minIndex = j;
            }
        }
        arr[minIndex] = arr[i];
        arr[i] = min;
    }
}
}
```

**插入排序 Inserting Sort**

```java
// 从第二个开始依次遍历判断
// 第i个元素的值为要插入的值 从i-1到0都为插入点 判断的依据是 插入值小于当前值
// 其中判断中 会 将插入值和插入点的数组往后移动一位
public static void InsertSort(int[] arr){
    int insertVal = 0;
    int insertIndex = 0;
    for (int i=1;i<arr.length;i++){
        insertVal = arr[i];
        insertIndex = i-1;
        while (insertIndex>=0 && arr[insertIndex]>insertVal){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex--;
        }
        if(insertIndex+1 != i){
            arr[insertIndex+1] = insertVal;
        }
    }
}
```

**Shell排序**

```java

```

