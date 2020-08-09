package com.veveup.dataStructures.linkedList;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class DoubleLinkedList {
    public static void main(String[] args) {
        // 创建几个节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");

        DoubleLinkedListEntry doubleLinkedListEntry = new DoubleLinkedListEntry();
        doubleLinkedListEntry.add(hero1);
        doubleLinkedListEntry.add(hero2);
        doubleLinkedListEntry.add(hero3);

        doubleLinkedListEntry.show();

        hero2.name = "小卢";
        doubleLinkedListEntry.update(hero2);
        System.out.println("修改过的列表");
        doubleLinkedListEntry.show();

        System.out.println("删除过的列表");
        doubleLinkedListEntry.deleteByNo(3);
        doubleLinkedListEntry.show();
    }
}

class DoubleLinkedListEntry{
    HeroNode2 head = new HeroNode2(0,"","");
//    HeroNode2 end;

    public HeroNode2 getHead() {
        return head;
    }

    //添加节点
    public void add(HeroNode2 heroNode2){
        HeroNode2 tmp = head;
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = heroNode2;
        heroNode2.pre = tmp;
    }

    // 更新节点
    public void update(HeroNode2 heroNode2){
        HeroNode2 tmp = head.next;
        while (tmp!=null){
            if(tmp.no==heroNode2.no){
                tmp.name = heroNode2.name;
                tmp.nickname = heroNode2.nickname;
                return;
            }
            tmp = tmp.next;
        }
        System.out.println("没有找到修改的节点！");
    }

    // 删除节点ByNo
    public void deleteByNo(int no){
        HeroNode2 tmp = head.next;
        while (tmp!=null){
            if(tmp.no==no){
                tmp.pre.next = tmp.next;
                if(tmp.next!=null){
                    tmp.next.pre = tmp.pre;
                }
                return;
            }
            tmp = tmp.next;
        }
        System.out.printf("没有找到对应节点%d！\n",no);
    }


    // 打印节点
    public void show(){
        HeroNode2 tmp = head.next;
        while(tmp!=null){
            System.out.println(tmp);
            tmp= tmp.next;
        }
    }
}


class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
