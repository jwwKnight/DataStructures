package leecode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
//        ListNode l1 = new ListNode(-9, new ListNode(3, null));
//        ListNode l2 = new ListNode(5, new ListNode(7, null));
        ListNode l3 = mergeTwoLists2(l1, l2);
        while (l3 != null) {
            System.out.println(l3);
            l3 = l3.next;
        }

    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode l1current = l1;
        ListNode l2current = l2;

        ListNode l3 = null;
        ListNode l3current = l3;

        while (true) {
            if (l1current == null) {
                if (l2current != null) {
                    if (l3current == null) {
                        l3current = l2current;
                    } else {
                        l3current.next = l2current;
                    }
                    l2current = l2current.next;
                    continue;
                } else {
                    break;
                }
            } else {
                if (l2current != null) {
                    if (l1current.val <= l2current.val) {
                        if (l3current == null) {
                            l3current = l1current;
                        } else {
                            l3current.next = l1current;
                        }
                        l1current = l1current.next;
                        continue;
                    } else {
                        if (l3current == null) {
                            l3current = l2current;
                        } else {
                            l3current.next = l2current;
                        }
                        l2current = l2current.next;
                        continue;
                    }
                } else {
                    if (l3current == null) {
                        l3current = l1current;
                    } else {
                        l3current.next = l1current;
                    }
                    l1current = l1current.next;
                    continue;
                }
            }
        }
        return l3;
    }


    /*
        解题思路：
            l1作为基准，将l2逐个插入l1中（经过排序），
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1start = l1;//记录l1的开始节点，开始循环的时候要用
        ListNode l1current = l1;//循环里l1的当前节点
        ListNode l1pre = null;// 循环里l1的前一个节点
        ListNode l2start = l2;// 同上
        ListNode l2current = l2;

        if (l1 == null) {
            return l2;
        }

        // 外循环是l2
        while (l2current != null) {
            // 内循环是l1
            while (true) {
                if (l1current != null) {
                    if (l2current.val <= l1current.val) {
                        // l2的当前比l1的当前小就放在l1当前的前面
                        l2start = l2current.next;
                        l2current.next = l1current;

                        if (l1pre != null) {
                            // 如果l1前面还有其他节点
                            l1pre.next = l2current;
                        } else {
                            // 如果l1前面没有其他节点，把l2当前设置为l1的开始
                            l1start = l2current;
                        }
                        break;
                    }
                    // 位置没找到，就去比较下一个l1
                    l1pre = l1current;
                    l1current = l1current.next;
                } else {
                    // l1current == null 表示循环到l1最后一个了，就直接把l2当前的节点放在l1最后一个
                    l1pre.next = l2current;
                    l2start = l2current.next;
                    l2current.next = null;
                    break;
                }
            }
            // 找到了，开始找下一个l2的位置，回到l1和l2的开始
            l1current = l1start;
            l2current = l2start;
        }
        return l1start;
    }


}

@Data
@AllArgsConstructor
@ToString(exclude = "next")
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
