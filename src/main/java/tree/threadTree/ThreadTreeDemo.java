package tree.threadTree;


/**
 * 线索化二叉树
 */
public class ThreadTreeDemo {
    public static void main(String[] args) {
        TreadTreeNode n1 = new TreadTreeNode(1, "tom");
        TreadTreeNode n2 = new TreadTreeNode(3, "tom");
        TreadTreeNode n3 = new TreadTreeNode(6, "tom");
        TreadTreeNode n4 = new TreadTreeNode(8, "tom");
        TreadTreeNode n5 = new TreadTreeNode(10, "tom");
        TreadTreeNode n6 = new TreadTreeNode(14, "tom");

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        TreadTree treadTree = new TreadTree(n1);
//        System.out.println("10的前驱节点是=" + n5.left);//3
//        System.out.println("10的后置节点是=" + n5.right);//1

        treadTree.showThreadTreePre();

    }


}

class TreadTree {
    TreadTreeNode root;
    TreadTreeNode pre;

    public TreadTree(TreadTreeNode root) {
        this.root = root;
        threadNode(root);
    }

    /**
     * 前置打印线索化的树
     */
    public void showThreadTreePre() {
        TreadTreeNode node = root;
        // 1.找到最左边的叶子节点，线索化从这开始
        while (node != null) {

            while (node.leftThreadType == 0) {
                node = node.left;
            }

            // 2.打印
            System.out.println(node);

            // 3.一直往右输出
            while (node.rightThreadType == 1) {
                System.out.println(node.right);
                node = node.right;
            }

            node = node.right;
        }


    }

    /**
     * 线索化
     */
    private void threadNode(TreadTreeNode node) {
        if (node == null) {
            return;
        }
        // 线索化左边
        threadNode(node.left);

        // 线索化自己的左指针
        if (node.left == null) {
            node.left = pre;
            node.leftThreadType = 1;
        }
        // 线索化前驱的右指针
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightThreadType = 1;
        }
        pre = node;

        // 线索化右边
        threadNode(node.right);
    }
}

class TreadTreeNode {
    int no;
    String name;
    TreadTreeNode left;
    TreadTreeNode right;
    // 指向类型，1表示指向的是前驱或者后继节点。0表示指向的是子树
    int leftThreadType;
    int rightThreadType;

    public TreadTreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
