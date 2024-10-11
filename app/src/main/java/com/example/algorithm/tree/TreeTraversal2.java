package com.example.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历
 * ******5
 * ***4    6
 * *1  2
 */
public class TreeTraversal2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(6);

        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);

        root.left = left1;
        root.right = right1;

        left1.left = left2;
        left1.right = right2;

//        System.out.println("先序遍历 " + preTraversal(root));
//        System.out.println("中序遍历 " + inTraversal(root));
//        System.out.println("后序遍历 " + postTraversal(root));
//        System.out.println("层次遍历 " + BFS(root));
//        System.out.println("从底到顶的层次遍历 " + BFSReverse(root));
//        System.out.println(binaryTreePaths(root));
/**************************递归法 先序遍历********************************************/
//        List<Integer> res = new ArrayList<>();
//        preTraversalCur(root, res);
//        System.out.println(Arrays.toString(res.toArray(res.toArray())));
/************************遍历 翻转二叉树********************************************/
        System.out.println("先序遍历 " + preTraversal(root));
        System.out.println("翻转后: " + preTraversal(invertTreeDFS(root)));


    }
/**********************************************************************/
/********************************深度优化遍历*******************************/
/**********************************************************************/

    /**
     * 递归法
     * 先序遍历 根左右
     */
    public static List<Integer> preTraversalCur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return null;
        }
        res.add(root.data);
        preTraversalCur(root.left, res);
        preTraversalCur(root.right, res);
        return res;
    }

    /**
     * 递归法
     * 中序遍历 左根右
     */
    public static List<Integer> inTraversalCur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return null;
        }
        preTraversalCur(root.left, res);
        res.add(root.data);
        preTraversalCur(root.right, res);
        return res;
    }

    /**
     * 递归法
     * 中序遍历 左根右
     */
    public static List<Integer> postTraversalCur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return null;
        }
        preTraversalCur(root.left, res);
        preTraversalCur(root.right, res);
        res.add(root.data);
        return res;
    }

    /**
     * 统一迭代法 先序遍历 根左右
     * 入栈顺序 右左根
     */
    public static List<Integer> preTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                st.push(node);
                st.push(null);
            } else {
                //处理
                st.pop();//空结点出栈
                node = st.peek();
                st.pop();
                res.add(node.data);//添加到结果集
            }
        }
        return res;
    }

    /**
     * 统一迭代法 中序遍历 左中右
     * 入栈顺序 右中左
     */
    public static List<Integer> inTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                st.push(node);
                st.push(null);
                if (node.left != null) st.push(node.left);
            } else {
                //处理
                st.pop();
                node = st.peek();
                st.pop();
                res.add(node.data);
            }
        }
        return res;
    }

    /**
     * 统一迭代法 后序遍历 左右中
     * 入栈顺序 中右左
     */
    public static List<Integer> postTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                st.push(node);
                st.push(null);
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
            } else {
                //处理
                st.pop();
                node = st.peek();
                st.pop();
                res.add(node.data);
            }
        }
        return res;
    }


/**********************************************************************/
/********************************广度优化遍历(层次遍历)*******************************/
/**********************************************************************/
    /**
     * 层次遍历使用队列
     */
    public static StringBuffer BFS(TreeNode root) {
        StringBuffer res = new StringBuffer();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                TreeNode node = que.poll();
                res.append(node.data);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                --size;
            }
            res.append("\n");
        }
        return res;
    }

    /**
     * 从最底层到顶层的层次遍历 从左子树到右子树的顺序
     * 使用队列
     */
    public static StringBuffer BFSReverse(TreeNode root) {
        StringBuffer res = new StringBuffer();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                TreeNode node = que.poll();
                res.append(node.data);
                if (node.right != null) que.offer(node.right);
                if (node.left != null) que.offer(node.left);
                --size;
            }
            res.append("\n");
        }
        return res.reverse();
    }

/**********************************************************************/
/********************************翻转二叉树 使用前序和后序遍历*******************************/
/**********************************************************************/
    /**
     * 翻转二叉树
     * DFS 深度优先
     * 递归法
     */
    public static TreeNode invertTreeDFSRecursive(TreeNode root) {
        if (root == null) return null;
        invertTreeDFSRecursive(root.left);
        invertTreeDFSRecursive(root.right);
        swap(root);
        return root;
    }

    /**
     * 翻转二叉树
     * DFS 深度优先
     * 前序遍历法
     */
    public static TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();//取栈顶元素
            if (node != null) {
                st.pop();//栈顶元素出栈
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                st.push(node);
                st.push(null);
            } else {
                st.pop();
                node = st.pop();
                swap(node);
            }
        }
        return root;
    }

    /**
     * 翻转二叉树
     * BFS 广度优先遍历方式
     *
     * @param root
     */
    public static TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return null;
        ArrayDeque<TreeNode> que = new ArrayDeque<TreeNode>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                swap(node);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return root;
    }

    private static void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    /**********************************************************************/
/********************************对称二叉树*******************************/
    /**********************************************************************/
    public static boolean symmertyTree(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (left == null && right == null) continue;//左右结点都为空证明是对称的
            if (left != null || right != null || left.data != right.data) return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

/**********************************************************************/
/********************************二叉树最大深度*******************************/
    /**********************************************************************/
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return depth;
    }
/**********************************************************************/
/********************************二叉树最小深度*******************************/
    /**********************************************************************/
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> que = new ArrayDeque<>();
        int depth = 0;
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = que.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return depth;
    }
/**********************************************************************/
/********************************二叉树所有路径*******************************/
    /**********************************************************************/
    /**
     * 迭代法
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Object> stack = new Stack<>();
        // 节点和路径同时入栈
        stack.push(root);
        stack.push(root.data + "");
        while (!stack.isEmpty()) {
            // 节点和路径同时出栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.data);
            }
            //左子节点不为空
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.data);
            }
        }
        return result;
    }
}
