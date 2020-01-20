package linkedList;

import lombok.ToString;

public class Josephu {
    /*
    Josephu(约瑟夫、约瑟夫环)  问题
    Josephu  问题为：设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，
    数到m 的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，
    由此产生一个出队编号的序列。

    提示：用一个不带头结点的循环链表来处理Josephu 问题：先构成一个有n个结点的单循环链表，
    然后由k结点起从1开始计数，计到m时，对应结点从链表中删除，然后再从被删除结点的下一个结点又从1开始计数，
    直到最后一个结点从链表中删除算法结束。
     */

    public static void main(String[] args) {
        CircleSingleLinkedList csll = new CircleSingleLinkedList();
        csll.gameStart(10, 20, 125);
    }


}

class CircleSingleLinkedList {
    Boy first = null; //指向第一个boy，用于把每次新加的boy指向first，形成环

    public void gameStart(int startNo, int count, int boyNum) {
        // 要出圈的boy即为被first指向的boy
        buildBoys(boyNum);
        showBoys();
        System.out.println("============================");
        Boy last = first;//first的上一个boy，用于移出frist指向的boy后与下一个进行关联

        // 1.先把first移到startNo的位置,last移到first-1的位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
        }
        while (last.next != first) {
            last = last.next;
        }
        // 2.再循环移动first和last，每次移动count，直到只剩一个boy
        while (last != first) {
            // 报数
            for (int i = 0; i < count - 1; i++) {
                first = first.next;
                last = last.next;
            }
            // 出圈
            System.out.printf("本次出圈的小朋友是：%d号\n", first.no);
            last.next = first.next;
            first.next = null;
            first = last.next;
        }
        System.out.printf("最后出圈的小朋友是：%d号\n", first.no);
    }

    public void buildBoys(int num) {
        Boy cur = null;//辅助指针，标识当前最后一个boy

        for (int i = 1; i <= num; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                cur = boy;
            } else {
                cur.next = boy;
                boy.next = first;
                cur = boy;
            }
        }
    }

    public void showBoys() {
        Boy cur = first;//辅助指针，标识即将打印的boy
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
            if (cur == first) {
                break;
            }
        }
    }

}

@ToString(exclude = "next")
class Boy {
    int no;
    Boy next;

    public Boy(int no) {
        this.no = no;
    }

}

