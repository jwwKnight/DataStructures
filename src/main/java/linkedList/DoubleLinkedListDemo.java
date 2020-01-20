package linkedList;

import lombok.ToString;

import java.util.zip.CRC32;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList list1 = new DoubleLinkedList();
//        list1.add(new HeroNode(2, "魏武帝曹操"));
//        list1.add(new HeroNode(1, "昭烈帝刘备"));
//        list1.add(new HeroNode(3, "吴王孙十万"));
//        list1.add(new HeroNode(4, "威震华夏关羽"));
//        list1.add(new HeroNode(5, "万人敌张飞"));
//
//        System.out.println("==========原链表===========");
//        list1.show();
//        System.out.println("==========update===========");
//        list1.updata(new HeroNode(3, "吴大帝孙权"));
//        list1.show();
//        System.out.println("==========update===========");
//        list1.del(new HeroNode(4, ""));
//        list1.show();


        list1.addByOrder(new HeroNode(4, "威震华夏关羽"));
        list1.addByOrder(new HeroNode(2, "魏武帝曹操"));
        list1.addByOrder(new HeroNode(1, "昭烈帝刘备"));
        list1.addByOrder(new HeroNode(3, "吴王孙十万"));
        list1.addByOrder(new HeroNode(5, "万人敌张飞"));
        list1.show();
    }


}

class DoubleLinkedList {
    HeroNode head = new HeroNode(0, "");

    public void add(HeroNode heroNode) {
        HeroNode cur = head.next;
        if (cur == null) {
            head.next = heroNode;
            heroNode.pre = head;
            return;
        }
        while (true) {
            if (cur.next == null) {
                cur.next = heroNode;
                heroNode.pre = cur;
                break;
            }
            cur = cur.next;
        }
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode cur = head;
        while (true) {
            if (cur.next == null) {
                cur.next = heroNode;
                heroNode.pre = cur;
                break;
            } else if (cur.next.no > heroNode.no) {
                cur.next.pre = heroNode;
                heroNode.next = cur.next;
                heroNode.pre = cur;
                cur.next = heroNode;
                break;
            } else if (cur.no == heroNode.no) {
                return;
            } else {
                cur = cur.next;
            }
        }
    }

    public void updata(HeroNode heroNode) {
        HeroNode cur = head.next;
        if (cur == null) {
            return;
        }
        while (cur.no != heroNode.no) {
            cur = cur.next;
        }
        cur.name = heroNode.name;
    }

    public void del(HeroNode heroNode) {
        HeroNode cur = head.next;
        if (cur == null) {
            return;
        }
        while (cur.no != heroNode.no) {
            cur = cur.next;
        }
        cur.pre.next = cur.next;
        if (cur.next != null) {
            cur.next.pre = cur.pre;
        }
    }

    public void show() {
        HeroNode cur = head.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }


}

class HeroNode {
    int no;
    String name;
    HeroNode pre;
    HeroNode next;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
