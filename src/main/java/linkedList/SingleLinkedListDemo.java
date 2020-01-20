package linkedList;

import javafx.scene.shape.Path;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class SingleLinkedListDemo {


    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(new HeroNode(1, "及时雨宋江"));
//        singleLinkedList.add(new HeroNode(2, "玉麒麟卢俊义"));
//        singleLinkedList.add(new HeroNode(3, "智多星吴用"));
//        singleLinkedList.add(new HeroNode(4, "豹子头林冲"));
        singleLinkedList.addByOrder(new HeroNode(2, "玉麒麟卢俊义"));
        singleLinkedList.addByOrder(new HeroNode(4, "豹子头林冲"));
        singleLinkedList.addByOrder(new HeroNode(1, "及时雨宋江"));
        singleLinkedList.addByOrder(new HeroNode(3, "智多星吴用"));
        singleLinkedList.addByOrder(new HeroNode(3, "智多星吴用"));
        singleLinkedList.show();

        System.out.println("================");
        singleLinkedList.updata(new HeroNode(5,"菠萝头林冲"));
        singleLinkedList.show();

    }

    static class SingleLinkedList {
        HeroNode head = new HeroNode(0, null);

        public void add(HeroNode heroNode) {
            HeroNode mark = head;
            while (mark.next != null) {
                mark = mark.next;
            }
            mark.next = heroNode;
        }

        public void addByOrder(HeroNode heroNode) {
            HeroNode mark = head;
            boolean flag = false;//标志用于判断有没有重复，为false则可以插入
            while (true) {
                if (mark.next == null) {
                    // 不存在下一个，就插在当前节点后面
                    break;
                } else if (mark.next.no > heroNode.no) {
                    // 下一个编号更大，就插在当前节点后面
                    break;
                } else if (mark.next.no == heroNode.no) {
                    // 发现当前节点和新节点的no相同，不插入
                    flag = true;
                    break;
                } else {
                    // 继续判断下一个
                    mark = mark.next;
                }
            }
            if (flag) {
                System.out.printf("编号重复，无法插入 => no = %d\n", heroNode.no);
            } else {
                heroNode.next = mark.next;
                mark.next = heroNode;
            }
        }

        public void updata(HeroNode heroNode) {
            HeroNode mark = head;
            while (mark != null && mark.no != heroNode.no) {
                mark = mark.next;
            }
            if (mark == null) {
                System.out.printf("找不到no = %d\n", heroNode.no);
            } else {
                mark.name = heroNode.name;
            }

        }


        public void show() {
            HeroNode mark = head.next;
            if (mark == null) {
                return;
            }
            do {
                System.out.println(mark);
                mark = mark.next;
            } while (mark != null);
        }

    }

    @ToString(exclude = "next")
    @Getter
    @Setter
    static class HeroNode {
        int no;
        String name;
        HeroNode next;

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;

        }
    }


}
