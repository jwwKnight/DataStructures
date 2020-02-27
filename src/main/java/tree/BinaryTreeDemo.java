package tree;

/**
 * 二叉树
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode tn1 = new TreeNode(1, "11");
        bt.root = tn1;
        TreeNode tn2 = new TreeNode(2, "22");
        TreeNode tn3 = new TreeNode(3, "33");
        TreeNode tn4 = new TreeNode(4, "44");
        TreeNode tn5 = new TreeNode(5, "55");
        tn1.left = tn2;
        tn1.right = tn3;
        tn3.right = tn4;
        tn3.left = tn5;

        bt.preOrder();
        System.out.println("========================");
        bt.delNode(3);
        System.out.println("========================");
        bt.preOrder();
//        System.out.println(bt.preFind(4));


    }

}

class BinaryTree {
    TreeNode root;

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        }
    }

    public TreeNode preFind(int no) {
        if (this.root != null) {
            return this.root.preFind(no);
        }
        return null;
    }

    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        }
    }

    public void backOrder() {
        if (this.root != null) {
            this.root.backOrder();
        }
    }

    public void delNode(int no) {
        if (this.root == null) {
            return;
        }
        if (this.root.no == no) {
            this.root = null;
            return;
        }
        this.root.delNode(no);
    }
}

class TreeNode {
    int no;
    String name;
    TreeNode left;
    TreeNode right;

    public TreeNode(int no, String name) {
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

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 前序查找
     */
    public TreeNode preFind(int no) {
        System.out.println("前序查找");
        if (no == this.no) {
            return this;
        }
        if (this.left != null) {
            TreeNode treeNode = this.left.preFind(no);
            if (treeNode != null) {
                return treeNode;
            }
        }
        if (this.right != null) {
            TreeNode treeNode = this.right.preFind(no);
            if (treeNode != null) {
                return treeNode;
            }
        }
        return null;
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void backOrder() {
        if (this.left != null) {
            this.left.backOrder();
        }
        if (this.right != null) {
            this.right.backOrder();
        }
        System.out.println(this);
    }

    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }


    }
}
