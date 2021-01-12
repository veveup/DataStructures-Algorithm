package com.veveup.dataStructures.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add");
            System.out.println("list");
            System.out.println("exit");
            System.out.println("find");
            System.out.println("delete");
            System.out.println("help");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("please input id");
                    int id = scanner.nextInt();
                    System.out.println("please input name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("please input id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "delete":
                    System.out.println("please input id");
                    id = scanner.nextInt();
                    hashTab.deleteEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(1);

            }
        }

    }
}

class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    //构造器
    public HashTab(int size){
        this.size = size;
        // 初始化
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        int empLinkedListNO = hashFun(emp.id);

        empLinkedListArray[empLinkedListNO].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    public void findEmpById(int id){
        int empLinkedListNO = hashFun(id);
        Emp empById = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if(empById != null){
            System.out.println("找到了雇员："+empById.id);
        }else{
            System.out.println("没有找到雇员！");
        }

    }

    public void deleteEmpById(int id){
        int empLinkedListNO = hashFun(id);
        int deleteResult = empLinkedListArray[empLinkedListNO].deleteEmpById(id);
        if (deleteResult>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    //散列函数
    public int hashFun(int id){
        return id % size;
    }
}

// 雇员类
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

// 链表
class EmpLinkedList{
    //头指针
    private Emp head; //默认为null
    public void add(Emp emp){
        if(head==null){
            head = emp;
            return;
        }

        Emp curEmp = this.head;
        while (true){
            if(curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int index){
        if(head==null){
            System.out.println(index+"链表为空！");
            return;
        }
        System.out.println(index+"链表信息：");
        Emp curEmp = this.head;
        while (true){
            System.out.printf(" => id=%d name=%s\n",curEmp.id,curEmp.name);
            if(curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }

    }

    public Emp findEmpById(int id){
        if(head == null){
            System.out.println("链表为空！");
            return null;
        }
        Emp curEmp = this.head;
        while (true){
            if(curEmp.id==id){
                break;
            }
            if(curEmp.next==null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    public int deleteEmpById(int id){
        if(findEmpById(id)==null){
            System.out.println("没有找到该id");
            return -1;
        }
        Emp pre = this.head;
        while (pre.next!=null&&pre.next.id!=id){
            pre = pre.next;
        }
        if(pre.next!=null){
            pre.next = pre.next.next;
        }else{
            this.head = null;
        }
        return 1;
    }
}
