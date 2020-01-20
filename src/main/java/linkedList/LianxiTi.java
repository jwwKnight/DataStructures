package linkedList;

import javax.swing.text.DefaultEditorKit;
import java.util.Stack;

public class LianxiTi {

    public static void main(String[] args) {

        lianxi1();
    }

    // 单链表的反转
    public static void lianxi1() {
        SingleLinkedListDemo.SingleLinkedList list = new SingleLinkedListDemo.SingleLinkedList();
        list.add(new SingleLinkedListDemo.HeroNode(2, "玉麒麟卢俊义"));
        list.add(new SingleLinkedListDemo.HeroNode(4, "豹子头林冲"));
        list.add(new SingleLinkedListDemo.HeroNode(1, "及时雨宋江"));
        list.add(new SingleLinkedListDemo.HeroNode(3, "智多星吴用"));
        System.out.println("================原链表================");
        list.show();

//        reserveList(list);

        System.out.println("================反转链表================");
        xianli2(list);
//        list.show();
    }

    private static void reserveList(SingleLinkedListDemo.SingleLinkedList list) {
         /*
            思路：
            1.新建一个链表
            2.遍历旧链表，遍历出的数据放在新链表的最前面，删除旧链表已转移的数据
            3.把旧链表头指向新链表
         */
        SingleLinkedListDemo.SingleLinkedList newList = new SingleLinkedListDemo.SingleLinkedList();

        SingleLinkedListDemo.HeroNode cur = list.head.getNext();//保存原列表当前正在转移的元素
        SingleLinkedListDemo.HeroNode next;

        while (cur != null) {
            next = cur.getNext();//保存下一个元素的地址，因为待会要改现元素的next值，会丢失next的地址
            cur.setNext(newList.head.getNext());//改现元素的next值为新列表的第一个元素，因为现元素即将取代他（新列表的第一个元素）的位置
            newList.head.setNext(cur);//新列表的第一个位置设置为现元素
            cur = next;//现元素后移
        }
//        list.head.setNext(newList.head.getNext());
        list.head = newList.head;//把旧表的头指向新表的头
    }

    // 逆序打印链表
    public static void xianli2(SingleLinkedListDemo.SingleLinkedList list) {
        Stack<SingleLinkedListDemo.HeroNode> stack = new Stack<SingleLinkedListDemo.HeroNode>();
        SingleLinkedListDemo.HeroNode cur = list.head.getNext();

        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}
