package linkedList;

public class LianxiTi2 {

    /*
    两个有序链表合成一个有序链表
     */
    public static void main(String[] args) {
        SingleLinkedListDemo.SingleLinkedList list1 = new SingleLinkedListDemo.SingleLinkedList();
        list1.addByOrder(new SingleLinkedListDemo.HeroNode(3, "3"));
        list1.addByOrder(new SingleLinkedListDemo.HeroNode(1, "1"));
        list1.addByOrder(new SingleLinkedListDemo.HeroNode(6, "6"));
        list1.addByOrder(new SingleLinkedListDemo.HeroNode(4, "4"));

        SingleLinkedListDemo.SingleLinkedList list2 = new SingleLinkedListDemo.SingleLinkedList();
        list2.addByOrder(new SingleLinkedListDemo.HeroNode(5, "5"));
        list2.addByOrder(new SingleLinkedListDemo.HeroNode(2, "2"));
        list2.addByOrder(new SingleLinkedListDemo.HeroNode(9, "9"));
        list2.addByOrder(new SingleLinkedListDemo.HeroNode(7, "7"));

        System.out.println("==============原链表1==============");
        list1.show();
        System.out.println("==============原链表2==============");
        list2.show();

        /*
            以list1为基础，逐个取出list2的元素，每当发现list2当前元素小于list1的next元素，
            就把list2当前元素放在list1当前元素之后，next元素之前
         */
//        SingleLinkedListDemo.SingleLinkedList newList = new SingleLinkedListDemo.SingleLinkedList();
        SingleLinkedListDemo.SingleLinkedList newList = list2;

        SingleLinkedListDemo.HeroNode cur1 = list1.head.next;
//        SingleLinkedListDemo.HeroNode cur2 = list2.head.next;
        SingleLinkedListDemo.HeroNode next;

        while (cur1 != null) {
            next = cur1.next;
            newList.addByOrder(cur1);
            cur1 = next;
        }

//        while (cur2 != null) {
//            next = cur2.next;
//            newList.addByOrder(cur2);
//            cur2 = next;
//        }
        System.out.println("==============合并链表==============");
        newList.show();

    }
}
