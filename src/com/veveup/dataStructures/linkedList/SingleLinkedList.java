package com.veveup.dataStructures.linkedList;

public class SingleLinkedList {
    public static void main(String[] args) {
        // 创建几个节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        SingleLinkedListEntry singleLinkedListEntry = new SingleLinkedListEntry();
//        singleLinkedListEntry.add(hero1);
//        singleLinkedListEntry.add(hero2);
//        singleLinkedListEntry.add(hero3);

        singleLinkedListEntry.addByOrder(hero2);
        singleLinkedListEntry.addByOrder(hero3);
        singleLinkedListEntry.addByOrder(hero1);
//        singleLinkedListEntry.addByOrder(hero3);

        singleLinkedListEntry.show();
//        hero2.name = "老卢";
//        singleLinkedListEntry.updateByNo(hero2);
//        HeroNode hero5 = new HeroNode(5, "小王", "小王吧");
//        singleLinkedListEntry.updateByNo(hero5);

//        singleLinkedListEntry.deleteByNo(5);
//        singleLinkedListEntry.show();

        System.out.printf("有效节点个数%d\n",SingleLinkedListEntry.getLength(singleLinkedListEntry.getHead()));
    }
}

// 定义SingleLinkedList 管理英雄
class SingleLinkedListEntry{
    // 初始化一个头节点
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向链表的最后
    public void add(HeroNode heroNode){
        HeroNode tmp = head;
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = heroNode;
    }

    // 根据顺序添加链表
    public void addByOrder(HeroNode heroNode){
        // 找到添加的前一个节点
        HeroNode tmp = head;
        boolean flag = false; // 是否存在编号
        while(tmp.next!=null){
            if(tmp.next.no > heroNode.no){
                heroNode.next = tmp.next;
                tmp.next = heroNode;
                break;
            }else if (tmp.next.no == heroNode.no){
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if(flag){
            System.out.printf("准备插入的英雄%d编号已经存在 ,不能加入\n",heroNode.no);
        }else{
            tmp.next = heroNode;
        }
    }

    // 根据 no 来修改
    public void updateByNo(HeroNode heroNode){
        if(head.next==null){
            System.out.println("链表为空！");
            return;
        }

        HeroNode tmp = head;
        while(tmp.next!=null){
            if(tmp.next.no == heroNode.no){
                tmp.next.name = heroNode.name;
                tmp.next.nickName = heroNode.nickName;
                return;
            }
            tmp = tmp.next;
        }
        System.out.printf("没有找到对应节点 %d \n",heroNode.no);
    }

    // 删除节点
    public void deleteByNo(int no){
        HeroNode tmp = head;
        while(tmp.next!=null){
            if(tmp.next.no == no){
                tmp.next = tmp.next.next;
                return;
            }
            tmp = tmp.next;
        }
        System.out.printf("没有对应节点 %d！\n",no);

    }

    // 节点中有效个数
    public static int getLength(HeroNode head){
        int length = 0;
        HeroNode tmp = head.next;
        // 不统计头节点
        while (tmp!=null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }
    // 显示链表 遍历
    public void show(){
        HeroNode tmp = head;
        while (tmp.next!=null){
            System.out.println(tmp);
            tmp = tmp.next;
        }
        // 打印最后一个节点
        System.out.println(tmp);
    }

    public HeroNode getHead() {
        return head;
    }
}

// 定义HeroNode 节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
