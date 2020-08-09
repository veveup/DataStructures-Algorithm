package com.veveup.dataStructures.linkedList;

public class CircleSingleLinkedList {
    public static void main(String[] args) {
        CircleSingleLinkedListEntry circleSingleLinkedListEntry = new CircleSingleLinkedListEntry();
        circleSingleLinkedListEntry.addBoy(60);
        circleSingleLinkedListEntry.show();
        circleSingleLinkedListEntry.getJoesphuList(1,2);
    }


}

class CircleSingleLinkedListEntry{
    private Boy first = null;

    public void getJoesphuList(int startNo,int countNum){
        if(first==null || startNo<0 ){
            System.out.println("参数有误！");
            return;
        }
        // 用来记录需要移除节点的前一个节点 用于 移除后 将两个节点连接起来
        Boy helper = first;
        while (helper.getNext()!=first){
            helper = helper.getNext();
        }

        // 先跳到起始位置
        for (int i =   1; i < startNo; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }


        // 若只剩最后一个元素 则结束
        while (first.getNext()!=first){
            for (int j = 0; j < countNum-1; j++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            // 现在出圈 first
            System.out.printf("出圈编号：%d\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        // 使用 do while 会好一些 可以直接输出全部的出圈节点
        System.out.printf("最后一个编号%d\n",first.getNo());

    }

    public void addBoy(int nums){
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i = 1 ; i <=nums ; i++) {
            // 根据编号 创建boy节点
            Boy boy = new Boy(i);
            if(i==1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }

    }

    public void show(){
        Boy tmp = first;
//        while (tmp.getNext()!=first){
//            System.out.printf("Boy编号：%d\n",tmp.getNo());
//            tmp = tmp.getNext();
//        }
        do {
            System.out.printf("Boy编号：%d\n",tmp.getNo());
            tmp = tmp.getNext();
        }while (tmp!=first);
        System.out.println("遍历链表结束");
    }

}



//单个节点
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
