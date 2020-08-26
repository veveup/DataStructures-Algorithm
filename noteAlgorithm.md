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
// 也是一种插入排序 优化了插入排序插入排序时 比较移动次数过多的问题 使用了二分的思想 
// 将长度每次除2 得到step 
// 然后以step为步长 分组 然后分组内交换或者移动排序
// 然后再/2 获得新的步长 继续分组排序
// 直至step=1 进行最后一步插入插入排序
 public static void ShellSort2(int[] arr){
    for(int step=arr.length/2;step>0;step /= 2){ 
        for(int i = step;i<arr.length;i++){
            int j = i;
            int temp = arr[j];
            if(arr[j]< arr[j-step]){
                while (j-step>=0 && temp<arr[j-step]){
                    arr[j] = arr[j-step];
                    j-=step;
                }
            }
            arr[j] = temp;
        }
    }
}
```

**快速排序 Quicksort**

```java
// 是冒泡排序的优化 利用了分治的思想
// 找一个中间值 这个中间值的位置不重要 然后以这个中间值为标准 
// 0-right 的值都是小于中间值的 left-length-1的都为大于等于中间值的 
// 然后再将左右两边 分别 重复上面步骤
public static void quickSort(int[] arr,int left,int right){
    int l = left;
    int r = right;
    int tmp = 0;
    int pivot = arr[(left+right)/2];
    while (l<r){
        // 在 pivot 左边找到个 大于 pivot的
        while ((arr[l]<pivot)){
            l+=1;
        }
        // 在 pivot 右边找到个 小于 pivot的
        while (arr[r]>pivot){
            r-=1;
        }
        if(l>=r){
            break;
        }
        tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
        if(arr[l] == pivot){
            r--;
        }
        if(arr[r] == pivot){
            l++;
        }
    }
    if(l==r){
        l+=1;
        r-=1;
    }
    if(left<r){
        quickSort(arr,left,r);
    }
    if(right>r){
        quickSort(arr,l,right);
    }
}
```

**归并排序 MergeSort**

```

```

