package com.example.algorithm;

/**
 * @author : wanghailong
 * @date :
 * @description: 二叉查找树 也叫作二叉排序树
 * 二叉查找树要求，在树中的任意一个节点，
 * 其左子树中的每个节点的值，都要小于这个节点的值，
 * 而右子树节点的值都大于这个节点的值
 */
public class BinarySearchTree {

    private Node tree;

    /**
     * 查找
     * <p>
     * 我们先取根节点，
     * 如果它等于我们要查找的数据，那就返回。
     * 如果要查找的数据比根节点的值小，那就在左子树中递归查找；
     * 如果要查找的数据比根节点的值大，那就在右子树中递归查找
     *
     * @param data
     * @return
     */
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;//外部类可以访问内部类 private / protected 属性和方法
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    /**
     * 插入
     * <p>
     * 如果要插入的数据比节点的数据大，并且节点的右子树为空，就将新数据直接插到右子节点的位置；
     * 如果不为空，就再递归遍历右子树，查找插入位置。
     * 同理，如果要插入的数据比节点数值小，并且节点的左子树为空，就将新数据插入到左子节点的位置；
     * 如果不为空，就再递归遍历左子树，查找插入位置
     *
     * @param data 待插入数据
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {//data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
                p.getData();
            }
        }
    }

    /**
     * 删除
     * <p>
     * 第一种情况是，如果要删除的节点没有子节点，
     * 我们只需要直接将父节点中，指向要删除节点的指针置为 null。比如图中的删除节点 55。
     * <p>
     * 第二种情况是，如果要删除的节点只有一个子节点（只有左子节点或者右子节点），
     * 我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了。比如图中的删除节点 13。
     * <p>
     * 第三种情况是，如果要删除的节点有两个子节点，这就比较复杂了。
     * 我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。
     * 然后再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），
     * 所以，我们可以应用上面两条规则来删除这个最小节点。比如图中的删除节点 18
     *
     * @param data
     */
    public void delete(int data) {
        Node p = tree;//指向要删除的结点，初始化指向根结点
        Node pp = null;//记录p的父结点

        //找到要删除的结点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) {
            return;//没有找到
        }
        //要删除的结点有两个子结点
        if (p.right != null && p.left != null) {
            Node minP = p.right;//minP表示右子树中的最小结点
            Node minPP = minP;//minPP表示minP的父结点
            while (minP.left != null) {//查找右子树中的最小结点
                minPP = minP;
                minP = minP.left;
            }

            p.data = minP.data;//将minP的数据替换到p中
            p = minP;//下面就变成删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) tree = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        protected int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        Node p = new Node(20);
        System.out.println("输出 node 值为：" + p.getData());
    }

}

